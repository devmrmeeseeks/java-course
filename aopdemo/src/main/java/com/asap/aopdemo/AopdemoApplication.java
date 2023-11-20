package com.asap.aopdemo;

import com.asap.aopdemo.dao.AccountDao;
import com.asap.aopdemo.dao.MembershipDao;
import com.asap.aopdemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDao accountDao,
											   MembershipDao membershipDao,
											   TrafficFortuneService trafficFortuneService) {
		return runner -> {
//			demoTheBeforeAdvice(accountDao, membershipDao);
//			demoTheAfterReturningAdvice(accountDao);
//			demoTheAfterThrowingAdvice(accountDao);
//			demoTheAfterAdvice(accountDao);
//			demoTheAroundAdvice(trafficFortuneService);
			demoTheAroundAdviceHandleException(trafficFortuneService);
		};
	}

	private void demoTheAroundAdviceHandleException(TrafficFortuneService trafficFortuneService) {
		System.out.println("\n\nMain Program: AroundDemoApp");
		System.out.println("----");
		System.out.println("Calling getFortune()");

		String data = trafficFortuneService.getFortune(true);

		System.out.println("\nMy fortune is: " + data);
		System.out.println("Finished");
	}

	private void demoTheAroundAdvice(TrafficFortuneService trafficFortuneService) {
		System.out.println("\n\nMain Program: AroundDemoApp");
		System.out.println("----");
		System.out.println("Calling getFortune()");

		String data = trafficFortuneService.getFortune();

		System.out.println("\nMy fortune is: " + data);
		System.out.println("Finished");
	}

	private void demoTheAfterAdvice(AccountDao accountDao) {
		List<Account> accounts = null;
		try {
			boolean tripWire = false;
			accounts = accountDao.findAccounts(tripWire);
		} catch (Exception e) {
			System.out.println("\n\nMain Program ... caught exception: " + e);
		}

		System.out.println("\n\nMain Program: AfterReturningDemoApp");
		System.out.println("----");
		System.out.println(accounts);
	}

	private void demoTheAfterThrowingAdvice(AccountDao accountDao) {
		List<Account> accounts = null;
		try {
			boolean tripWire = true;
			accounts = accountDao.findAccounts(tripWire);
		} catch (Exception e) {
			System.out.println("\n\nMain Program ... caught exception: " + e);
		}

		System.out.println("\n\nMain Program: AfterReturningDemoApp");
		System.out.println("----");
		System.out.println(accounts);
	}

	private void demoTheAfterReturningAdvice(AccountDao accountDao) {
		List<Account> accounts = accountDao.findAccounts();
		System.out.println("\n\nMain Program: AfterReturningDemoApp");
		System.out.println("----");
		System.out.println(accounts);
	}

	private void demoTheBeforeAdvice(AccountDao accountDao, MembershipDao membershipDao) {
		Account account = new Account("Madhu", "Platinum");
		accountDao.addAccount(account, true);
		accountDao.doWork();

		accountDao.setName("foobar");
		accountDao.setServiceCode("silver");

		membershipDao.addSillyMember();
		membershipDao.goToSleep();
	}

}
