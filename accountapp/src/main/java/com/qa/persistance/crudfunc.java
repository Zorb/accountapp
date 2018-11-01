package com.qa.persistance;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.accountapp.management.Account;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class crudfunc implements AccountRepo {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	@Override
	public String getAllAccounts() {
		Query query = manager.createQuery("Select a FROM Accounts a ORDER BY a.title DESC");
		Collection<Account> accounts = (Collection<Account>) query.getResultList();
		// Converting Object to JSON
		return util.getJSONForObject(accounts);
	}

	@Override
	@Transactional(REQUIRED)
	public String addAccount(String account) {
		Account aAccount = util.getObjectForJSON(account, Account.class);
		manager.persist(aAccount);
		return "{\"message\": \"account has been sucessfully added\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteAccount(Long id) {
		Account accountInDB = findAccount(id);
		if (accountInDB != null) {
			manager.remove(accountInDB);
		}
		return "{\"message\": \"account sucessfully deleted\"}";
	}

	public String getAccount(Long id) {
		Account accountInDB = findAccount(id);

		return util.getJSONForObject(accountInDB);

	}

	public String updateAccount(Long id, String AccountToUp) {
		Account updated = util.getObjectForJSON(AccountToUp, Account.class);
		Account accountInDB = findAccount(id);
		if (AccountToUp != null) {
			accountInDB = updated;
			manager.merge(accountInDB);
		}
		return "{\"message\": \"account has been sucessfully updated\"}";

	}

	private Account findAccount(Long id) {
		return manager.find(Account.class, id);
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}


}
