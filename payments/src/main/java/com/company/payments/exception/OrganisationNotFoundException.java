/*
 * 
 */
package com.company.payments.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The Class OrganisationNotFoundException.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class OrganisationNotFoundException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new organisation not found exception.
	 *
	 * @param organisationId the organisation id
	 */
	public OrganisationNotFoundException(String organisationId) {
		super("could not find organisation for '" + organisationId + "'.");
	}
}