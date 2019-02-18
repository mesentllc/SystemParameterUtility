package com.mesentllc.utilities.systemparameterutility.exceptions;

public class FileProcessingException extends Exception {
	public FileProcessingException() {
		super();
	}

	public FileProcessingException(String string) {
		super(string);
	}

	public FileProcessingException(Exception e) {
		super(e);
	}
}
