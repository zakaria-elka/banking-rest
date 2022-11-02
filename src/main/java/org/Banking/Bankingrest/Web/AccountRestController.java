package org.Banking.Bankingrest.Web;

import com.example.bankservices.DTO.BankAccountRequestDTO;
import com.example.bankservices.DTO.BankAccountResponseDTO;
import com.example.bankservices.Entities.BankAccount;
import com.example.bankservices.Repositories.AccountRepository;
import com.example.bankservices.Services.AccountService;
import com.example.bankservices.mappers.AccountMapper;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class AccountRestController {

    private AccountRepository accountRepository;
    private AccountService accountService;
    public AccountRestController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
@GetMapping("/bankAccount/{id}")
   public BankAccount bankAccount(@PathVariable String id){
        return accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account not Found"));

    }
    @GetMapping("/bankAccount/all")
    public List<BankAccount> bankAccountList(){
        return accountRepository.findAll();

    }
    @PostMapping("/bankAccount/add")
    public BankAccountResponseDTO bankAccountList(@RequestBody BankAccountRequestDTO bankAccount){
       if(bankAccount.getId()==null) bankAccount.setId(UUID.randomUUID().toString());
        return accountService.addAccount(bankAccount);

    }
    @PutMapping("/bankAccount/{id}")
public BankAccount save(@RequestBody BankAccount bankAccount,@PathVariable String id){
        BankAccount account=accountRepository.findById(id).orElseThrow(()-> {
            return new RuntimeException("");
        });
        if(bankAccount.getBalance()!=null)
account.setBalance(bankAccount.getBalance());
        if(bankAccount.getCurrency()!=null)
account.setCurrency(bankAccount.getCurrency());
        if(bankAccount.getType()!=null)
account.setType(bankAccount.getType());
        if(bankAccount.getCreatedAt()!=null)
account.setCreatedAt(new Date());


        return accountRepository.save(account);
    }

    @DeleteMapping("/bankaccount/delete/{id}")
    public void deleteBankAccount(@PathVariable String id){
          accountRepository.deleteById(id);
    }

}
