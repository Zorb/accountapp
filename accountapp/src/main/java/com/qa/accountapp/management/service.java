package com.qa.accountapp.management;

import java.util.HashMap;
import java.util.Map;

public class service {
	private Map<Integer, Account> account = new HashMap<Integer, Account>();
	private static int id = 1;



	public void addAccount(Account accountToAdd) {
		account.put(id, accountToAdd);
		id++;
	}

	public Account searchAccount(Account accountToSearch) {
		Account result = account.get("accountToSearch");
		return result;
	}
	public void delAccount(Integer idToDel) {
		account.remove(idToDel);
	}

	public Map<Integer, Account> getAccount() {
		return account;
	}

	public void setAccountMap(Map<Integer, Account> account) {
		this.account = account;
	}
}

