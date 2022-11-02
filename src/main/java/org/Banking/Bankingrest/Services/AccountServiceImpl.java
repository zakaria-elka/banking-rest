package org.Banking.Bankingrest.Services;

import com.example.bankservices.DTO.BankAccountRequestDTO;
import com.example.bankservices.DTO.BankAccountResponseDTO;
import com.example.bankservices.Entities.BankAccount;
import com.example.bankservices.Repositories.AccountRepository;
import com.example.bankservices.mappers.AccountMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {
private AccountRepository accountRepository;
    private AccountMapper accountMapper;

    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountRequestDTO) {
        BankAccount bankAccount=BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .balance(bankAccountRequestDTO.getBalance())
                .type(bankAccountRequestDTO.getType())
                .currency(bankAccountRequestDTO.getCurrency())

                .build();

        BankAccountResponseDTO bankAccountResponseDTO=accountMapper.fromBankAcc(bankAccount);



return bankAccountResponseDTO;
    }
}
