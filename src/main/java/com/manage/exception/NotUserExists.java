package com.manage.exception;

public class NotUserExists extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public NotUserExists(String msg) {
		super(msg);
	}

}
