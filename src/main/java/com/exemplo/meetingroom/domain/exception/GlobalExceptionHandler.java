package com.exemplo.meetingroom.domain.exception;

import java.time.OffsetDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.exemplo.meetingroom.domain.exception.ErrorDetails.ErrorDetailsBuilder;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {

		HttpStatus status = HttpStatus.NOT_FOUND;
		String message = ex.getMessage();
		String details = request.getDescription(false);
		ErrorDetailsBuilder errorDetails = createErrorDetailsBuilder(status, message, details);
		
		return handleExceptionInternal(ex, errorDetails, new HttpHeaders(), status, request);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleUncaught(Exception ex, WebRequest request) {
		
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;		
		String message = ex.getMessage();
		String details = request.getDescription(false);
		
		ErrorDetailsBuilder errorDetails = createErrorDetailsBuilder(status, message, details);

		return handleExceptionInternal(ex, errorDetails, new HttpHeaders(), status, request);
	}

	private ErrorDetails.ErrorDetailsBuilder createErrorDetailsBuilder(HttpStatus status, String message,
			String details) {

		return ErrorDetails.builder()
				.status(status.value())
				.timestamp(OffsetDateTime.now())
				.message(message)
				.details(details);
	}

}
