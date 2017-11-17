package com.company.payments.exception;

/**
 * The Class RestApiSubError.
 */
abstract class RestApiSubError {

}

class ApiValidationError extends RestApiSubError {
	private String object;
	private String message;

	ApiValidationError(String object, String message) {
		this.object = object;
		this.message = message;
	}
}