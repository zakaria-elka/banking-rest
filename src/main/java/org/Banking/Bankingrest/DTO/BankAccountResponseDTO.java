package org.Banking.Bankingrest.DTO;

import com.example.bankservices.Enum.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BankAccountResponseDTO {
    private String id;
    private Double balance;
    private String currency;
    private Date createdAt;
    private AccountType type;
}
