package com.qa.persistance;

public interface AccountRepo {

	String getAllAccounts();

	String addAccount(String account);

	String deleteAccount(Long id);

	String getAccount(Long id);

	String updateAccount(Long id, String AccountToUp);
}
