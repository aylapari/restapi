/*
 * Payments service interface class
 */
package com.company.payments.service;

import java.util.Collection;
import java.util.Optional;

import com.company.payments.model.Payment;

/**
 * The Interface PaymentsService.
 */
public interface PaymentsService {

	/**
	 * Creates the payments.
	 *
	 * @param payment
	 *            the payment
	 * @return the payment
	 */
	Payment create(Payment payment);

	/**
	 * Find all.
	 *
	 * @param id
	 *            the id
	 * @return the optional
	 */
	Optional<Collection<Payment>> findAll(String id);

	/**
	 * Find.
	 *
	 * @param id
	 *            the id
	 * @return the optional
	 */
	Optional<Payment> find(String id);

	/**
	 * Delete.
	 *
	 * @param id
	 *            the id
	 */
	void delete(String id);
}