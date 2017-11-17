/*
 * 
 */
package com.company.payments.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The Class PaymentNotFoundException.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class PaymentNotFoundException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new payment not found exception.
	 *
	 * @param paymentId the payment id
	 */
	public PaymentNotFoundException(String paymentId) {
		super("could not find payment for '" + paymentId + "'.");
	}
}