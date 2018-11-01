package com.qa.accountapp.app;

import com.qa.accountapp.management.Account;
import com.qa.persistance.crudfunc2;

public class App extends crudfunc2 {

	public static void main(String[] args) {
		Account bob = new Account("Bob", "Odenkirk", "wdqdwq1221");
		Account wefew = new Account("Bosdcdscb", "Odenkirk", "wdqdwq1221");
		Account bofewfb = new Account("Bcdscsdcob", "Odenkirk", "wdqdwq1221");
		Account bsdsdsdcob = new Account("Bdscsdcsdob", "Osdcdscsdcsddenkirk", "wdqdwq1221");
		crudfunc2 map = new crudfunc2();
			map.getAccount();
			map.addAccount(bob);
		map.addAccount(wefew);
		map.addAccount(bofewfb);
		map.addAccount(bsdsdsdcob);
		


	}



}
