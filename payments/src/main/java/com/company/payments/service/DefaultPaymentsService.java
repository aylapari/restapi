/*
 * The Default service class to connect with the repository
 * Create, update, delete and select the Payment object
 */
package com.company.payments.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.payments.model.Payment;
import com.company.payments.repository.PaymentsRepository;

/**
 * The Class DefaultPaymentsService.
 */
@Service
public class DefaultPaymentsService implements PaymentsService {

	/** The payments repository onject. */
	@Autowired
	private PaymentsRepository paymentsRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.company.payments.service.PaymentsService#create(com.company.payments.
	 * model.Payment)
	 */
	@Override
	public Payment create(Payment payment) {
		return paymentsRepository.save(payment);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.company.payments.service.PaymentsService#findAll(java.lang.String)
	 */
	@Override
	public Optional<Collection<Payment>> findAll(String organisationId) {
		return paymentsRepository.findByOrganisationId(organisationId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.company.payments.service.PaymentsService#find(java.lang.String)
	 */
	@Override
	public Optional<Payment> find(String paymentId) {
		return paymentsRepository.findById(paymentId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.company.payments.service.PaymentsService#delete(java.lang.String)
	 */
	@Override
	public void delete(String paymentId) {
		paymentsRepository.delete(paymentId);

	}

}