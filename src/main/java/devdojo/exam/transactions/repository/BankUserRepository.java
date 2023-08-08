package devdojo.exam.transactions.repository;

import devdojo.exam.transactions.domain.BankUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BankUserRepository extends JpaRepository<BankUser, Long> {
}
