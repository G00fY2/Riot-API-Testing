package com.g00fy2.riotapi.exception;

import com.g00fy2.riotapi.ApiUtils;

public class ResponseErrorException extends ApiException {
	private int statusCode;
	
	public ResponseErrorException(int responseCode)
	{
		super(ApiUtils.getHttpError(responseCode));
		statusCode = responseCode;
	}
	
	public int getStatus(){
		return statusCode;
	}
}
