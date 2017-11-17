package com.company.payments.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * The Class RestExceptionHandler.
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.web.servlet.mvc.method.annotation.
	 * ResponseEntityExceptionHandler#handleHttpMessageNotReadable(org.
	 * springframework.http.converter.HttpMessageNotReadableException,
	 * org.springframework.http.HttpHeaders, org.springframework.http.HttpStatus,
	 * org.springframework.web.context.request.WebRequest)
	 */
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String error = "Malformed JSON request";
		return buildResponseEntity(new RestApiError(HttpStatus.BAD_REQUEST, error, ex));
	}

	/**
	 * Builds the response entity.
	 *
	 * @param apiError
	 *            the api error
	 * @return the response entity
	 */
	private ResponseEntity<Object> buildResponseEntity(RestApiError apiError) {
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}

	// other exception handlers below

}