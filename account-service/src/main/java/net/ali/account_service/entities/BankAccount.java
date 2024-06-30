package net.ali.account_service.entities;

import jakarta.persistence.*;
import lombok.*;
import net.ali.account_service.enums.AccountType;
import net.ali.account_service.models.Customer;

import java.time.LocalDate;

@Entity @Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class BankAccount {

    @Id
    private String accountId;
    private double balance;
    private LocalDate createdAt;
    private String currency;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @Transient
    private Customer customer;

    private Long customerId;
}
