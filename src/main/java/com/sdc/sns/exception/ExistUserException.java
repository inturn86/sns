package com.sdc.sns.exception;


import lombok.Getter;

@Getter
public class ExistUserException extends RuntimeException{

	private final String errorMessage;
	public ExistUserException(String message) {
		this.errorMessage = message;
	}
}
