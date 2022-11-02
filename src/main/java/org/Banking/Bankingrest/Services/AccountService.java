package org.Banking.Bankingrest.Services;

import com.example.bankservices.DTO.BankAccountRequestDTO;
import com.example.bankservices.DTO.BankAccountResponseDTO;
import com.example.bankservices.Entities.BankAccount;

public interface AccountService {
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountRequestDTO);
}
