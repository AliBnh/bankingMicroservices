package net.ali.account_service;

import net.ali.account_service.entities.BankAccount;
import net.ali.account_service.enums.AccountType;
import net.ali.account_service.repository.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;

@EnableFeignClients
@SpringBootApplication
public class AccountServiceApplication {


	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}

		@Bean
		CommandLineRunner commandLineRunner(BankAccountRepository bankAccountRepository) {
			return args -> {
				BankAccount bankAccount = BankAccount.builder()
						.accountId(UUID.randomUUID().toString())
						.currency("MAD")
						.balance(98000)
						.accountType(AccountType.SAVINGS_ACCOUNT)
						.createdAt(LocalDate.now())
						.customerId(1L)
						.build();
				BankAccount bankAccount2 = BankAccount.builder()
						.accountId(UUID.randomUUID().toString())
						.currency("MAD")
						.balance(98000)
						.accountType(AccountType.CURRENT_ACCOUNT)
						.createdAt(LocalDate.now())
						.customerId(1L)
						.build();
				bankAccountRepository.save(bankAccount);
				bankAccountRepository.save(bankAccount2);
			};

	}

}

