package com.cg.payment.exception;

public class PaymentException extends Exception {
	public PaymentException(){
		super();
		
	}

	public PaymentException(String message){
		super(message);
	}
}
