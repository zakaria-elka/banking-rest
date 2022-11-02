package org.Banking.Bankingrest;

import com.example.bankservices.Entities.BankAccount;
import com.example.bankservices.Enum.AccountType;
import com.example.bankservices.Repositories.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
@AllArgsConstructor
public class BankServicesApplication {
	private AccountRepository accountRepository;

	public static void main(String[] args) {
		SpringApplication.run(BankServicesApplication.class, args);
	}
	@Bean
	CommandLineRunner start(){
		return args -> {
			for(int i=0;i<10;i++){
				BankAccount bankAccount=BankAccount.builder().id(UUID.randomUUID().toString())
						.type(Math.random()>0.5? AccountType.SAVING_ACC:AccountType.CURRENT_ACC)
						.balance(1000+Math.random()*10000)
						.createdAt(new Date())
						.currency("MAD")
						.build();
				accountRepository.save(bankAccount);
			}

		};

	}
}
