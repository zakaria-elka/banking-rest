package org.Banking.Bankingrest.Entities;

import com.example.bankservices.Enum.AccountType;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = BankAccount.class)
public interface AccountProjection {
    public String getId();
    public AccountType getType();
    public Double getBalance();

}
