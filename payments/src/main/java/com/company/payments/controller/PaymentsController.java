/*
 * The controller handle for the Payments REST API
 * Maps the request object to the method calls
 * The organisation is the base entity which drives the payment 
 */
package com.company.payments.controller;

import java.net.URI;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.company.payments.model.Payment;
import com.company.payments.service.PaymentsService;
import com.company.payments.exception.PaymentNotFoundException;
import com.company.payments.exception.OrganisationNotFoundException;

/**
 * The Class PaymentsController.
 */
@RestController
@RequestMapping("organisation")
public class PaymentsController {

	/** The payments service. 
	 * The service handles all the interactions with the repository
	 * */
	@Autowired
	private PaymentsService paymentsService;

	/**
	 * Read all the payments for an organisation.
	 * Validate the organisation
	 * Read all the payments for the organisation
	 * 
	 * @param organisationId
	 *            the organisation id
	 * @return the response entity
	 */
	@RequestMapping(value = "/{id}/payments", method = RequestMethod.GET)
	public ResponseEntity<Collection<Payment>> readPayments(@PathVariable("id") String organisationId) {
		// Validate the organisation to read the payments
		this.validateOrganisation(organisationId);
		
		// Read all the payments for the organisation
		Collection<Payment> paymentCollection = paymentsService.findAll(organisationId)
				.orElseThrow(() -> new OrganisationNotFoundException(organisationId));
		return new ResponseEntity<>(paymentCollection, HttpStatus.OK);
	}

	/**
	 * Create a single payment entity.
	 * The payment id is auto generated
	 * 
	 *
	 * @param organisationId
	 *            the organisation id
	 * @param payment
	 *            the payment
	 * @return the response entity
	 */
	@RequestMapping(value = "/{id}/payments", method = RequestMethod.POST)
	public ResponseEntity<?> addPayments(@PathVariable("id") String organisationId, @RequestBody Payment payment) {
		payment.setOrganisationId(organisationId);
		Payment paymentCreated = paymentsService.create(payment);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{payid}")
				.buildAndExpand(paymentCreated.getId()).toUri();
		return ResponseEntity.created(location).body(paymentCreated);

	}

	/**
	 * Save payments.
	 *
	 * @param payment
	 *            the payment
	 * @param paymentId
	 *            the payment id
	 * @param organisationId
	 *            the organisation id
	 * @return the response entity
	 */
	@RequestMapping(value = "/{id}/payments/{payid}", method = RequestMethod.PUT)
	public ResponseEntity<?> savePayments(@RequestBody Payment payment, @PathVariable("payid") String paymentId,
			@PathVariable("id") String organisationId) {
		this.paymentsService.find(paymentId).orElseThrow(() -> new PaymentNotFoundException(paymentId));
		payment.setId(paymentId);
		payment.setOrganisationId(organisationId);
		this.paymentsService.create(payment);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
		return ResponseEntity.created(uri).body(payment);
	}

	/**
	 * Delete payments.
	 *
	 * @param organisationId
	 *            the organisation id
	 * @param paymentId
	 *            the payment id
	 * @return the response entity
	 */
	@RequestMapping(value = "/{id}/payments/{payid}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deletePayments(@PathVariable("id") String organisationId,
			@PathVariable("payid") String paymentId) {
		return paymentsService.find(paymentId).map(p -> {
			paymentsService.delete(paymentId);
			return ResponseEntity.noContent().build();
		}).orElseThrow(() -> new PaymentNotFoundException(paymentId));
	}

	/**
	 * Read payment.
	 *
	 * @param organisationId
	 *            the organisation id
	 * @param paymentId
	 *            the payment id
	 * @return the payment
	 */
	@RequestMapping(value = "/{id}/payments/{payid}", method = RequestMethod.GET)
	public Payment readPayment(@PathVariable("id") String organisationId, @PathVariable("payid") String paymentId) {
		this.validateOrganisation(organisationId);
		return paymentsService.find(paymentId).orElseThrow(() -> new PaymentNotFoundException(paymentId));
	}

	/**
	 * Validate organisation.
	 *
	 * @param organisationId
	 *            the organisation id
	 */
	public void validateOrganisation(String organisationId) {
		this.paymentsService.findAll(organisationId)
				.orElseThrow(() -> new OrganisationNotFoundException(organisationId));
	}

}