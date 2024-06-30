package net.ali.account_service.repository;

import net.ali.account_service.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface BankAccountRepository extends JpaRepository<BankAccount, String> {
}
