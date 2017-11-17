/*
 * Payments Repository to manage the payments entity in DB
 */
package com.company.payments.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.payments.model.Payment;

/**
 * The Interface PaymentsRepository.
 */
public interface PaymentsRepository extends JpaRepository<Payment, String>{
	
	/**
	 * Find by organisation id and id.
	 *
	 * @param organisationId the organisation id
	 * @param paymentId the payment id
	 * @return the optional
	 */
	Optional<Payment> findByOrganisationIdAndId(String organisationId, String paymentId);
	
	/**
	 * Find by organisation id.
	 *
	 * @param organisationId the organisation id
	 * @return the optional
	 */
	Optional<Collection<Payment>> findByOrganisationId(String organisationId);
	
	/**
	 * Find by id.
	 *
	 * @param PaymentId the payment id
	 * @return the optional
	 */
	Optional<Payment> findById(String PaymentId);	
}