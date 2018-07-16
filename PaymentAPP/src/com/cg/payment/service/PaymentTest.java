package com.cg.payment.service;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

import com.cg.payment.bean.Payment;
import com.cg.payment.exception.PaymentException;

public class PaymentTest {
	private IPaymentService service=new PaymentService();
	@Test
	public void testCreateAccountForMobile() {
		Payment ac = new Payment();
		ac.setMobileNo("1234");
		ac.setName("Apj");
		ac.setEmail("apj@gmail.com");
		ac.setBalance(2000.0);
		try {
		service.createAccount(ac);
		} catch (PaymentException e) {
		assertEquals("Mobile number should contain 10 digits", e.getMessage());
		}
		}
			 
		@Test
		public void testCreateAccountForNameIsEmpty1() {
			Payment ac = new Payment();
		ac.setMobileNo("9010022374");
		ac.setName("");
		ac.setEmail("apj@gmail.com");
		ac.setBalance(3000.0);
		try {
		service.createAccount(ac);
		} catch (PaymentException e) {
		assertEquals("Name cannot be empty", e.getMessage());
		}
		}
		
		 
		
		 
		@Test
		public void testCreateAccount1() {
			Payment ac = new Payment();
		ac.setMobileNo("9010022374");
		ac.setName("Apj");
		ac.setEmail("apj@gmail.com");
		ac.setBalance(3000.0);
		try {
		String s=service.createAccount(ac);
		assertNotNull(s);
		} catch (PaymentException e) {
		//System.out.println(e.getMessage());
		 
		}
		 
		}
	

		@Test
		public void testShowBalanceForMobileNoDoesNotExist1() {
		try {
		service.showBalance("9010022374");
		} catch (PaymentException e) {
		// TODO Auto-generated catch block
		assertEquals("The mobile number does not exist",e.getMessage());
		}
		}
		
		@Test
		public void testShowBalanceForName1() {
			Payment ac=new Payment();
		ac.setMobileNo("1546548488");
		try {
		service.showBalance(ac.getMobileNo());
		assertEquals("Apj", ac.getName());
		} catch (PaymentException e) {
		// TODO Auto-generated catch block
		assertEquals("The mobile number does not exist",e.getMessage());
		}
		}
		 
		@Test
		public void testDepositForMobileNo1() {
			Payment ac=new Payment();
		ac.setMobileNo("95059345");
		try {
		service.deposit(ac.getMobileNo(), 230);
		} catch (PaymentException e) {
		// TODO Auto-generated catch block
		assertEquals("Mobile number should contain 10 digits",e.getMessage());
		}
		}
		@Test
		public void testDepositForMobileNoDoesNotExist1() {
			Payment ac=new Payment();
		ac.setMobileNo("9010022374");
		try {
		service.deposit(ac.getMobileNo(), 230);
		} catch (PaymentException e) {
		// TODO Auto-generated catch block
		assertEquals("The mobile number does not exist",e.getMessage());
		}
		}
		@Test
		public void testDepositForDepositAmt11() {
			Payment ac=new Payment();
		ac.setMobileNo("9010022374");
		try {
		service.deposit(ac.getMobileNo(), -230);
		} catch (PaymentException e) {
		// TODO Auto-generated catch block
		assertEquals("Deposit amount must be greater than zero",e.getMessage());
		}
		}
		 
		@Test
		public void testDeposit1() {
			Payment ac=new Payment();
		ac.setMobileNo("9010022374");
		try {
			Payment ac1=service.deposit(ac.getMobileNo(), 230);
		assertNotNull(ac1);
		} catch (PaymentException e) {
		 
		System.out.println(e.getMessage());
		}
		}
		 
		@Test
		public void testWithDrawForMobileNo1() {
			Payment ac=new Payment();
		ac.setMobileNo("95059345");
		try {
		service.withdraw(ac.getMobileNo(), 230);
		} catch (PaymentException e) {
		// TODO Auto-generated catch block
		assertEquals("Mobile number should contain 10 digits",e.getMessage());
		}
		}
		@Test
		public void testWithdrawForMobileNoDoesNotExist1() {
			Payment ac=new Payment();
		ac.setMobileNo("9010022374");
		try {
		service.withdraw(ac.getMobileNo(), 230);
		} catch (PaymentException e) {
		// TODO Auto-generated catch block
		assertEquals("The mobile number does not exist",e.getMessage());
		}
		}
		
		@Test
		public void testFundTransferForMobileNo1() {
			Payment ac=new Payment();
			Payment ac2=new Payment();
		ac.setMobileNo("95059345");
		ac2.setMobileNo("1234");
		try {
		service.fundTransfer(ac.getMobileNo(),ac2.getMobileNo(), 230);
		} catch (PaymentException e) {
		// TODO Auto-generated catch block
		assertEquals("Mobile number should contain 10 digits",e.getMessage());
		}
		}
		
		@Test
		public void testFundTransferForAmt1() {
			Payment ac=new Payment();
			Payment ac2=new Payment();
		ac.setMobileNo("9010022374");
		ac2.setMobileNo("9848468242");
		try {
		service.fundTransfer(ac.getMobileNo(), ac2.getMobileNo(),  -230);
		} catch (PaymentException e) {
		// TODO Auto-generated catch block
		assertEquals("The amount to be withdrawn should be greater than available balance and greater than zero",e.getMessage());
		}
		}
		@Test
		public void testFundTransfer1() {
			Payment ac=new Payment();
			Payment ac2=new Payment();
		ac.setMobileNo("9010022374");
		ac2.setMobileNo("9848468242");
		try {
		assertTrue(service.fundTransfer(ac.getMobileNo(), ac2.getMobileNo(),  230));
		} catch (PaymentException e) {
		// TODO Auto-generated catch block
		//System.out.println(e.getMessage());
		}
		}
		@Test
		public void testPrinttransactionDetails1() {
			Payment ac=new Payment();
		ac.setMobileNo("9848468242");
		try {
			Payment acc=service.printTransactionDetails(ac.getMobileNo());
		assertNotNull(acc);
		} catch (PaymentException e) {
		//System.out.println(e.getMessage());
		}
		 
		}
		 

		public void testCreateAccountForMobile1() {
			Payment ac = new Payment();
			ac.setMobileNo("1234");
			ac.setName("Selapa");
			ac.setEmail("selapa@gmail.com");
			ac.setBalance(3000.0);
			try {
			service.createAccount(ac);
			} catch (PaymentException e) {
			assertEquals("Mobile number should contain 10 digits", e.getMessage());
			}
			}
			 
			@Test
			public void testCreateAccountForName() {
				Payment ac = new Payment();
			ac.setMobileNo("1234567890");
			ac.setName("mark34");
			ac.setEmail("mark@gmail.com");
			ac.setBalance(500.0);
			try {
			service.createAccount(ac);
			} catch (PaymentException e) {
			Assert.assertEquals("Name should start with capital letter and should contain only alphabets", e.getMessage());
			}
			}
			 
			@Test
			public void testCreateAccountForNameIsEmpty() {
				Payment ac = new Payment();
			ac.setMobileNo("1234567890");
			ac.setName("");
			ac.setEmail("deepu@gmail.com");
			ac.setBalance(200.0);
			try {
			service.createAccount(ac);
			} catch (PaymentException e) {
			Assert.assertEquals("Name cannot be empty", e.getMessage());
			}
			}
			 
			@Test
			public void testCreateAccountForEmailId() {
				Payment ac = new Payment();
			ac.setMobileNo("1234567890");
			ac.setName("SaiKrishan");
			ac.setEmail("apj@@23gmail.com");
			ac.setBalance(200.0);
			try {
			service.createAccount(ac);
			} catch (PaymentException e) {
			Assert.assertEquals("Enter valid emailid", e.getMessage());
			}
			}
			
			 
			@Test
			public void testCreateAccount() {
				Payment ac = new Payment();
			ac.setMobileNo("1234567890");
			ac.setName("Deepika");
			ac.setEmail("deepu@gmail.com");
			ac.setBalance(200.0);
			 
			try {
			String s=service.createAccount(ac);
			assertNotNull(s);
			} catch (PaymentException e) {
			//System.out.println(e.getMessage());
			 
			}
			}	 
			/*public void testShowBalanceForMobileNoExist() {
			Account ac=new Account();
			ac.setMobileNo("9505928555");
			try {
			assertSame((2000.0, service.showBalance(ac.getMobileNo())));
			 
			 
			} catch (WalletException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			}
			}
			*/
			
			@Test
			public void testDepositForMobileNo() {
				Payment ac=new Payment();
			ac.setMobileNo("95059345");
			try {
			service.deposit(ac.getMobileNo(), 230);
			} catch (PaymentException e) {
			// TODO Auto-generated catch block
			assertEquals("Mobile number should contain 10 digits",e.getMessage());
			}
			}
			@Test
			public void testDeposit() {
				Payment ac=new Payment();
			ac.setMobileNo("9505928555");
			try {
				Payment ac1=service.deposit(ac.getMobileNo(), 230);
			assertNotNull(ac1);
			} catch (PaymentException e) {
			 
			//System.out.println(e.getMessage());
			}
			}
		
			@Test
			public void testWithdrawForMobileNoDoesNotExist() {
				Payment ac=new Payment();
			ac.setMobileNo("9505934512");
			try {
			service.withdraw(ac.getMobileNo(), 230);
			} catch (PaymentException e) {
			// TODO Auto-generated catch block
			assertEquals("The mobile number does not exist",e.getMessage());
			}
			}

			@Test
			public void testFundTransferForAmt() {
				Payment ac=new Payment();
				Payment ac2=new Payment();
			ac.setMobileNo("9010022374");
			ac2.setMobileNo("9700803073");
			try {
			service.fundTransfer(ac.getMobileNo(), ac2.getMobileNo(),  -230);
			} catch (PaymentException e) {
			// TODO Auto-generated catch block
			assertEquals("The amount to be withdrawn should be greater than available balance and greater than zero",e.getMessage());
			}
			}
			@Test
			public void testFundTransfer() {
				Payment ac=new Payment();
				Payment ac2=new Payment();
			ac.setMobileNo("9010022374");
			ac2.setMobileNo("9700803073");
			try {
			assertTrue(service.fundTransfer(ac.getMobileNo(), ac2.getMobileNo(),  230));
			} catch (PaymentException e) {
			// TODO Auto-generated catch block
			//System.out.println(e.getMessage());
			}
			}
			@Test
			public void testPrinttransactionDetails() {
				Payment ac=new Payment();
			ac.setMobileNo("9010022374");
			try {
				Payment acc=service.printTransactionDetails(ac.getMobileNo());
			assertNotNull(acc);
			} catch (PaymentException e) {
			//System.out.println(e.getMessage());
			}
			 
			}
			 

			}


