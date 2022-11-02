package org.Banking.Bankingrest.Repositories;

import com.example.bankservices.Entities.BankAccount;
import com.example.bankservices.Enum.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource
public interface AccountRepository extends JpaRepository<BankAccount, String> {
@RestResource(path ="/byType")
    List<BankAccount> findByType(AccountType type);
}
