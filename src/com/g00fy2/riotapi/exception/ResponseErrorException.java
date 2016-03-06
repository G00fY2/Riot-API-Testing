package com.g00fy2.riotapi.exception;

public class ResponseErrorException extends ApiException {

	public ResponseErrorException(String message)
	{
		super(message);
	}
	
	public ResponseErrorException(String message, Throwable cause)
	{
		super(message, cause);
	}
	
	public ResponseErrorException(int responseCode)
	{
		super("Status " + responseCode +" <- HTTP Error responded.");
	}
}
