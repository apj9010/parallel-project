package com.cg.payment.db;

import java.time.LocalDateTime;
import java.util.HashMap;

import com.cg.payment.bean.Payment;

public class PaymentDb {
	private static HashMap<String,Payment> payDb=new HashMap<String,Payment>();
	public static HashMap<String, Payment> getPaymentMap() {
	return payDb;
	}
	Payment apj=new Payment();
	static{
	 
	payDb.put("9010022374",new Payment("9010022374","Apj","apj@gmail.com",3000.0,LocalDateTime.now()));
	payDb.put("9700308073",new Payment("9700308073","SaiKrishan","sk@gmail.com",1000.0,LocalDateTime.now()));
	payDb.put("9000000712",new Payment("9000000712","Selapa","selap@gmail.com",2500.0,LocalDateTime.now()));
	payDb.put("9999999999",new Payment("9999999999","Palk","palk@gmail.com",5000.0,LocalDateTime.now()));
	}
	}
	