/*
 * The TDD test class for the payments controller
 * This class utilises spring boot test and it is combination of unit and integration tests 
 * where the backend database is also tested along with the class using the servlet class
 */
package com.company.payments.controller;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.company.payments.PaymentsApplication;
import com.company.payments.model.Attributes;
import com.company.payments.model.Payment;
import com.company.payments.repository.PaymentsRepository;

/**
 * The Class PaymentsControllerTest.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = PaymentsApplication.class)
@WebAppConfiguration
public class PaymentsControllerTest {

	/** The content type. */
	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

	/** The mock mvc. */
	private MockMvc mockMvc;

	/** The organisation id. */
	private String organisationId = "test-org";

	/** The mapping jackson 2 http message converter. */
	private HttpMessageConverter mappingJackson2HttpMessageConverter;

	/** The payment. */
	private Payment payment;

	/** The payment list. */
	private List<Payment> paymentList = new ArrayList<>();

	/** The payments repository. */
	@Autowired
	private PaymentsRepository paymentsRepository;

	/** The web application context. */
	@Autowired
	private WebApplicationContext webApplicationContext;

	/**
	 * Sets the message converters to convert the java objects to JSON and JSON to
	 * java objects.
	 *
	 * @param converters
	 *            the new converters
	 */
	@Autowired
	void setConverters(HttpMessageConverter<?>[] converters) {

		this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream()
				.filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter).findAny().orElse(null);

		assertNotNull("the JSON message converter must not be null", this.mappingJackson2HttpMessageConverter);
	}

	/**
	 * Setup before the test.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Before
	public void setup() throws Exception {
		// Mock class which sets up the application context
		this.mockMvc = webAppContextSetup(webApplicationContext).build();

		// clean up the repository
		this.paymentsRepository.deleteAllInBatch();

		Attributes attributes = new Attributes();
		// Create the test payment object
		this.payment = paymentsRepository.save(new Payment("Payment", "", 1, "test-org", attributes));
	}

	/**
	 * Test case to test that organisation not found exception when unknown
	 * organisation is is passed.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testOrganisationNotFound() throws Exception {
		mockMvc.perform(
				get("/organisation/test-org/payments/10").content(this.json(new Payment())).contentType(contentType))
				.andExpect(status().isNotFound());
	}

	/**
	 * Read single payment.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testReadSinglePayment() throws Exception {
		mockMvc.perform(get("/organisation/" + organisationId + "/payments/" + this.payment.getId()))
				.andExpect(status().isOk()).andExpect(content().contentType(contentType))
				.andExpect(jsonPath("$.id", is(this.payment.getId()))).andExpect(jsonPath("$.version", is(1)))
				.andExpect(jsonPath("$.type", is("Payment")));
	}

	/**
	 * Read payments.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testReadPayments() throws Exception {
		mockMvc.perform(get("/organisation/" + organisationId + "/payments/")).andExpect(status().isOk())
				.andExpect(content().contentType(contentType)).andExpect(jsonPath("$[0].id", is(this.payment.getId())))
				.andExpect(jsonPath("$[0].version", is(1))).andExpect(jsonPath("$[0].type", is("Payment")));
	}

	/**
	 * Creates the payment.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testCreatePayment() throws Exception {
		String paymentJson = json(this.payment);
		this.mockMvc.perform(
				post("/organisation/" + organisationId + "/payments/").contentType(contentType).content(paymentJson))
				.andExpect(status().isCreated());
	}

	/**
	 * Delete payment.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testDeletePayment() throws Exception {
		this.mockMvc.perform(delete("/organisation/" + organisationId + "/payments/" + this.payment.getId()))
				.andExpect(status().isNoContent());
	}

	/**
	 * Converts the java object to Json String.
	 *
	 * @param o
	 *            the o
	 * @return the string
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	protected String json(Object o) throws IOException {
		MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
		this.mappingJackson2HttpMessageConverter.write(o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
		return mockHttpOutputMessage.getBodyAsString();
	}
}