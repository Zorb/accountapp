package com.qa.persistance;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.qa.accountapp.management.Account;
import com.qa.util.JSONUtil;

@ApplicationScoped
@Alternative
public class crudfunc2 {
	Map<Integer, Account> account = new HashMap<Integer, Account>();
	private static int id = 1;

	@Inject
	private JSONUtil util;
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

	public String getAllAccounts() {
		return util.getJSONForObject(account.values());
	}

	public void addAccount(Account accountToAdd) {
		account.put(id, accountToAdd);
		id++;
	}

	public Account getAccount(Account idToSearch) {
		Account result = account.get("idToSearch");
		return result;
	}

	public void deleteAccount(Integer idToDel) {
		account.remove(idToDel);
	}

	public Map<Integer, Account> getAccount() {
		return account;
	}

	public void setAccountMap(Map<Integer, Account> account) {
		this.account = account;
	}
}

