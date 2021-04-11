package com.db.stock.TransactionManagement.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_ACCEPTABLE,reason="HIGHER VERSION IS ALREADY PRESENT")
public class RejectTradeException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public RejectTradeException(String message) {
		super(message);
	}

	

}
