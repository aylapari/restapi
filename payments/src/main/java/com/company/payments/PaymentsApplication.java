/*
 * Spring boot application class for spring to initiate
 * 
 * The application servers the payments resource
 * Operations included -
 * 
 * Get all payments - /organisation/{organisationId}/payments
 * Get a single payment - /organisation/{organisationId}/payments/{paymentId}
 * Create payment - /organisation/{organisationId}/payments
 * Delete payment - /organisation/{organisationId}/payments/{paymentId}
 * Update payment - /organisation/{organisationId}/payments/{paymentId}
 * 
 * For simplicity the payment id and organisation ids are not UUID and are simple numbers in String format
 */
package com.company.payments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The Class PaymentsApplication.
 */
@SpringBootApplication
public class PaymentsApplication {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(PaymentsApplication.class, args);
	}
}
