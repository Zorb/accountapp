package com.cognizant.tests;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qa.accountapp.management.Account;

public class AccountTests {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}


	@Test
	public void accountTest() {
		Account testAccount = new Account("sasadas", "ascascasc", "ascascascasc");
		
	}

	@Test
	public void featureTest() {
		Account testAccount = new Account("sasadas", "ascascasc", "ascascascasc");
		// testAccount.searchName("sasadas");
		Assert.assertTrue(testAccount.searchName("sasadas"));
	}
}
