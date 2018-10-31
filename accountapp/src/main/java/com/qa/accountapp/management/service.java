package com.qa.accountapp.management;

import java.util.HashMap;
import java.util.Map;

public class service {
	Map<Integer, Account> account = new HashMap<Integer, Account>();
	private static int id = 1;


	public Boolean searchName(String NameToSearch) {
		int count = 0;
		// for (Account it : account.values()) {
		// if (it.getFirstName().equals(NameToSearch)) {
		// count++;
		// }
		// }
		long s = account.entrySet().stream().filter(e -> e.getValue().getFirstName().equals(NameToSearch)).count();

		System.out.println(s + " people with that name.");
		if (s > 0) {
			return true;
		}
		return false;
	}
	public void addAccount(Account accountToAdd) {
		account.put(id, accountToAdd);
		id++;
	}

	public Account searchAccount(Account idToSearch) {
		Account result = account.get("idToSearch");
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

