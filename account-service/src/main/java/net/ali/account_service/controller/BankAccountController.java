package net.ali.account_service.controller;

import net.ali.account_service.clients.CustomerRestClient;
import net.ali.account_service.entities.BankAccount;
import net.ali.account_service.models.Customer;
import net.ali.account_service.repository.BankAccountRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class BankAccountController {
    private BankAccountRepository bankAccountRepository;
    private CustomerRestClient customerRestClient;

    public BankAccountController(BankAccountRepository bankAccountRepository, CustomerRestClient customerRestClient) {
        this.bankAccountRepository = bankAccountRepository;
        this.customerRestClient = customerRestClient;
    }

    @GetMapping("/accounts")
    public List<BankAccount> getAllBankAccounts() {

        List<BankAccount> bankAccounts = bankAccountRepository.findAll();
        for (BankAccount bankAccount : bankAccounts) {
            Customer customer = customerRestClient.findCustomerById(bankAccount.getCustomerId());
            bankAccount.setCustomer(customer);
        }
    return bankAccounts;
    }

    @GetMapping("/accounts/{id}")
    public BankAccount getBankAccountById(@PathVariable String id) {
        BankAccount bankAccount= bankAccountRepository.findById(id).orElse(null);
        Customer customer = customerRestClient.findCustomerById(bankAccount.getCustomerId());
        bankAccount.setCustomer(customer);
        return bankAccount;
    }
    @PostMapping("/accounts")
    public BankAccount saveBankAccount(BankAccount bankAccount) {
        return bankAccountRepository.save(bankAccount);
    }
    @DeleteMapping("/accounts/{id}")
    public void deleteBankAccount(String id) {
        bankAccountRepository.deleteById(id);
    }


}
