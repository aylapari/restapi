package com.company.payments.exception;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * The Class RestApiError.
 */
class RestApiError {

	/** The status. */
	private HttpStatus status;
	
	/** The timestamp. */
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;
	
	/** The message. */
	private String message;
	
	/** The debug message. */
	private String debugMessage;
	
	/** The sub errors. */
	private List<RestApiSubError> subErrors;

	/**
	 * Instantiates a new rest api error.
	 */
	private RestApiError() {
		timestamp = LocalDateTime.now();
	}

	/**
	 * Instantiates a new rest api error.
	 *
	 * @param status the status
	 */
	RestApiError(HttpStatus status) {
		this();
		this.status = status;
	}

	/**
	 * Instantiates a new rest api error.
	 *
	 * @param status the status
	 * @param ex the ex
	 */
	RestApiError(HttpStatus status, Throwable ex) {
		this();
		this.status = status;
		this.message = "Unexpected error";
		this.debugMessage = ex.getLocalizedMessage();
	}

	/**
	 * Instantiates a new rest api error.
	 *
	 * @param status the status
	 * @param message the message
	 * @param ex the ex
	 */
	RestApiError(HttpStatus status, String message, Throwable ex) {
		this();
		this.status = status;
		this.message = message;
		this.debugMessage = ex.getLocalizedMessage();
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public HttpStatus getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}