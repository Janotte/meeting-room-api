package com.exemplo.meetingroom.domain.exception;

import java.time.OffsetDateTime;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ErrorDetails {

	private Integer status;
	private OffsetDateTime timestamp;
	private String message;
	private String details;

}
