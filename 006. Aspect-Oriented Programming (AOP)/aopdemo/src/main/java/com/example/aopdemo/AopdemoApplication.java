package com.example.aopdemo;

import com.example.aopdemo.dao.AccountDAO;
import com.example.aopdemo.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AopdemoApplication implements CommandLineRunner {

	private final AccountDAO accountDAO;
	private final AccountService accountService;

	public AopdemoApplication(AccountDAO accountDAO, AccountService accountService) {
		this.accountDAO = accountDAO;
		this.accountService = accountService;
	}

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		this.accountDAO.addAccount();
		this.accountService.addAccount();
	}
}
