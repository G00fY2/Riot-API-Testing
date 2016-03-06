package com.g00fy2.riotapi.exception;

public class IllegalApiParameterException extends ApiException {

	public IllegalApiParameterException(String message)
	{
		super(message);
	}
	
	public IllegalApiParameterException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
