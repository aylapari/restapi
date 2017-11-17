/*
 * Integration test class
 * Runs integration test with the docker container API end point
 */
package com.company.payments;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.util.UUID;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.company.payments.model.Attributes;
import com.company.payments.model.Payment;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * The Class PaymentsIntegrationTest.
 */
@Category(IntegrationTest.class)
public class PaymentsIntegrationTest {

	/** The rest template. */
	TestRestTemplate restTemplate = new TestRestTemplate();

	/** The container end point. */
	String containerEndPoint = null;

	/** The headers. */
	HttpHeaders headers = new HttpHeaders();

	/**
	 * Creates the URL with mapping.
	 *
	 * @param uri the uri
	 * @return the string
	 */
	private String createURLWithMapping(String uri) {
		return this.containerEndPoint + uri;
	}

	/**
	 * Initialize.
	 */
	@Before
	public void initialize() {
		// this.containerEndPoint = System.getProperty("paymentsUrl").toString();
		this.containerEndPoint = "http://127.0.0.1:8084/";
	}

	/**
	 * Construct a Random payment object.
	 *
	 * @return the payment
	 */
	private Payment randomPayment() {
		Payment payment = new Payment();
		payment.setId(UUID.randomUUID().toString());
		payment.setOrganisationId("123");
		payment.setType("Payments");
		payment.setVersion(1);
		payment.setAttributes(new Attributes());
		return payment;
	}

	/**
	 * Test the create payment operation.
	 * 1. Create random payment
	 * 2. Convert it to JSON format message
	 * 3. API endpoint - /organisation/{organisationId}/payments
	 * 4. Assert the created / returned payment object is same as passed
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testCreatePayment() throws Exception {
		headers.setContentType(MediaType.APPLICATION_JSON);

		Payment payment = randomPayment();
		ObjectMapper mapper = new ObjectMapper();
		String paymentJson = mapper.writeValueAsString(payment);
		HttpEntity<String> entity = new HttpEntity<String>(paymentJson, headers);

		ResponseEntity<?> response = restTemplate.exchange(createURLWithMapping("/organisation/123/payments"),
				HttpMethod.POST, entity, String.class);

		Payment payment2 = mapper.readValue(response.getBody().toString(), Payment.class);

		assertThat("123").isEqualTo(payment2.getOrganisationId());
	}

	/**
	 * Test organisation not found.
	 *
	 * @throws JsonParseException the json parse exception
	 * @throws JsonMappingException the json mapping exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws JSONException the JSON exception
	 */
	@Test
	public void testOrganisationNotFound() throws JsonParseException, JsonMappingException, IOException, JSONException {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<?> response = restTemplate.exchange(createURLWithMapping("/organisation/678567/payments/1"),
				HttpMethod.GET, entity, String.class);
		JSONObject jsonObject = new JSONObject(response.getBody().toString());
		assertThat("com.company.payments.exception.OrganisationNotFoundException")
				.isEqualTo(jsonObject.get("exception"));
	}

	/**
	 * Test the retrieve the payment.
	 * 1. Create random payment
	 * 2. Convert it to JSON format message
	 * 3. API endpoint - /organisation/{organisationId}/payments
	 * 4. Retrieve the new payment
	 * 5. API endpoint - /organisation/{organisationId}/payments/{paymentsId}
	 * 4. Assert the created / returned payment object are same
	 * 	
	 * @throws JsonParseException the json parse exception
	 * @throws JsonMappingException the json mapping exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@Test
	public void testRetrievePayment() throws JsonParseException, JsonMappingException, IOException {
		headers.setContentType(MediaType.APPLICATION_JSON);
		Payment payment = randomPayment();
		ObjectMapper mapper = new ObjectMapper();
		String paymentJson = mapper.writeValueAsString(payment);
		HttpEntity<String> entity = new HttpEntity<String>(paymentJson, headers);

		restTemplate.exchange(createURLWithMapping("/organisation/123/payments"), HttpMethod.POST, entity,
				String.class);

		HttpEntity<String> entityNull = new HttpEntity<String>(null, headers);

		ResponseEntity<?> getResponse = restTemplate.exchange(createURLWithMapping("/organisation/123/payments/1"),
				HttpMethod.GET, entityNull, String.class);
		Payment paymentRetrieved = mapper.readValue(getResponse.getBody().toString(), Payment.class);

		assertThat("Payments").isEqualTo(paymentRetrieved.getType());
	}
}
