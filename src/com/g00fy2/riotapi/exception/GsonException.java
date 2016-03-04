package com.g00fy2.riotapi.exception;

public class GsonException extends ApiException {

	public GsonException(String message)
	{
		super(message);
	}
	
	public GsonException(String message, Throwable cause)
	{
		super(message, cause);
	}
}