package com.training.boothibernate.exceptions;

public class SubjectNotFoundException extends RuntimeException{
	public SubjectNotFoundException(String message) {
		super(message);
	}
}
