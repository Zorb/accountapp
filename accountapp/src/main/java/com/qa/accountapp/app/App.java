package com.qa.accountapp.app;

import org.json.JSONObject;

import com.qa.accountapp.management.Account;
import com.qa.accountapp.management.service;

public class App extends service {

	public static void main(String[] args) {
		 	Account bob = new Account("Bob", "Odenkirk", "wdqdwq1221");
			service map = new service();
			map.getAccount();
			map.addAccount(bob);
			
			
			
		

		JSONObject json = new JSONObject(map);
		System.out.println(json);

	}



}
