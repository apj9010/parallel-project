package com.cg.payment.service;

import java.time.LocalDateTime;

import com.cg.payment.bean.Payment;
import com.cg.payment.dao.IPaymentDao;
import com.cg.payment.dao.PaymentDao;
import com.cg.payment.exception.PaymentException;

public class PaymentService implements IPaymentService {
	IPaymentDao dao = new PaymentDao();

	@Override
	public String createAccount(Payment pay) throws PaymentException {
		// TODO Auto-generated method stub
		if (!pay.getMobileNo().matches("\\d{10}")) {
			throw new PaymentException("Mobile number should contain 10 digits");
	}
	if (pay.getName().isEmpty() || pay.getName() == null) {
	throw new PaymentException("Name cannot be empty");
	} else {
	if (!pay.getName().matches("[A-Z][A-Za-z]{3,}")) {
	throw new PaymentException("Name should start with capital letter and should contain only alphabets");
	}
	}
	if (pay.getEmail().matches("[a-z0-9]+@[a-z]+\\.com")) {
	throw new PaymentException("Enter valid emailid");
	}
	if (pay.getBalance() <= 0) {
	throw new PaymentException("Balance should be greater than zero");
	}
	return dao.createAccount(pay);
	}

	@Override
	public double showBalance(String mobileNo) throws PaymentException {
		if (!mobileNo.matches("\\d{10}")) {
			throw new PaymentException("Mobile number should contain 10 digits");
			}
			return dao.showBalance(mobileNo);
			}

	@Override
	public Payment deposit(String mobileNo, double depositAmt) throws PaymentException {
		
		if (!mobileNo.matches("\\d{10}")) {
			throw new PaymentException("Mobile number should contain 10 digits");
			}
		
		Payment pay = dao.deposit(mobileNo);

		
			if (depositAmt <= 0) {
			throw new PaymentException("Deposit amount must be greater than zero");
			}
			pay.setBalance(pay.getBalance() + depositAmt);
			pay.setDate(LocalDateTime.now());
			return pay;
	}


	@Override
	public Payment withdraw(String mobileNo, double withdrawAmt)
			throws PaymentException {
		if (!mobileNo.matches("\\d{10}")) {
			throw new PaymentException("Mobile number should contain 10 digits");
			}
			Payment pay = dao.withdraw(mobileNo);
			if (withdrawAmt > pay.getBalance() || withdrawAmt <= 0) {
			throw new PaymentException(
			"The amount to be withdrawn should be greater than available balance and greater than zero");
			}
			pay.setBalance(pay.getBalance() - withdrawAmt);
			pay.setDate(LocalDateTime.now());
			return pay;
			
	}

	@Override
	public boolean fundTransfer(String sourceMobileNo, String destMobileNo,
			double transferAmt) throws PaymentException {
		if (!sourceMobileNo.matches("\\d{10}")) {
			throw new PaymentException("Mobile number should contain 10 digits");
			}
			if (!destMobileNo.matches("\\d{10}")) {
			throw new PaymentException("Mobile number should contain 10 digits");
			}
			IPaymentService service = new PaymentService();
			Payment pay1 = service.withdraw(sourceMobileNo, transferAmt);
			Payment pay2 = service.deposit(destMobileNo, transferAmt);
			return true;
			}

	@Override
	public Payment printTransactionDetails(String mobileNo)
			throws PaymentException {
		return dao.printTransactionDetails(mobileNo);
	}
		
	}
	

	

		



