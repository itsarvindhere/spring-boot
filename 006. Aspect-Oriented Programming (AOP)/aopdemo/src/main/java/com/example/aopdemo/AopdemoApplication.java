package com.example.aopdemo;

import com.example.aopdemo.dao.AccountDAO;
import com.example.aopdemo.dao.MembershipDAO;
import com.example.aopdemo.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication implements CommandLineRunner {

	private final AccountDAO accountDAO;
	private final AccountService accountService;
	private final MembershipDAO membershipDAO;

	public AopdemoApplication(AccountDAO accountDAO, AccountService accountService, MembershipDAO membershipDAO) {
		this.accountDAO = accountDAO;
		this.accountService = accountService;
		this.membershipDAO = membershipDAO;
	}

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		methodCallsForBeforeAdvice();

		methodCallsForAfterReturningAdvice();

	}

	void methodCallsForAfterReturningAdvice() {
		List<Account> accounts = this.accountDAO.findAccounts();
		System.out.println("Method findAccounts() called from the main Class.");
		System.out.println("Accounts are :" + accounts);
	}

	void methodCallsForBeforeAdvice() {
		this.accountDAO.addAccount();

		Account account = new Account("1", "John");
		this.accountDAO.addAccount(account);

		this.accountDAO.addAccount(account, true);

		this.accountDAO.setName("John");
		this.accountDAO.getName();

		this.accountDAO.setServiceCode("1234");
		this.accountDAO.getServiceCode();

		this.membershipDAO.addMember();
	}
}
