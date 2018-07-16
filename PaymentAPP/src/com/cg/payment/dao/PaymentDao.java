package com.cg.payment.dao;

import java.util.HashMap;

import com.cg.payment.bean.Payment;
import com.cg.payment.db.PaymentDb;
import com.cg.payment.exception.PaymentException;

public class PaymentDao implements IPaymentDao {
	private static HashMap<String, Payment> payMap = PaymentDb.getPaymentMap();

	@Override
	public String createAccount(Payment pay) throws PaymentException {
		payMap.put(pay.getMobileNo(),pay);
		return pay.getMobileNo();
	}

	@Override
	public double showBalance(String mobileNo) throws PaymentException {
		Payment pay = payMap.get(mobileNo);
		if (pay == null) {
		throw new PaymentException("The mobile number does not exist");
		}
		return pay.getBalance();
		}


	@Override
	public Payment deposit(String mobileNo) throws PaymentException {
		Payment pay = payMap.get(mobileNo);
		if (pay == null) {
		throw new PaymentException("The mobile number does not exist");
		}
		return pay;
	}

	@Override
	public Payment withdraw(String mobileNo) throws PaymentException {
		// TODO Auto-generated method stub
		Payment pay = payMap.get(mobileNo);
		if (pay == null) {
		throw new PaymentException("The mobile number does not exist");
		}
		return pay;
	
	}

	@Override
	public Payment printTransactionDetails(String mobileNo)
			throws PaymentException {
		Payment pay = payMap.get(mobileNo);
		if (pay == null) {
		throw new PaymentException("The mobile number does not exist");
		}
		return pay;
		}

	}

	


