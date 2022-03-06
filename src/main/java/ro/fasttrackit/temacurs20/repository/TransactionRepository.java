package ro.fasttrackit.temacurs20.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fasttrackit.temacurs20.entity.Transaction;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    List<Transaction> byType(String type);
    List<Transaction> byMinAmount(double minAmount);
    List<Transaction> byMaxAmount(double maxAmount);
    List<Transaction>  byTypeAndMin(String type, double minAmount);
    List<Transaction> byTypeAndMax(String type, double maxAmount);
    List<Transaction> byMinAndMax(double minAmount, double maxAmount);
    List<Transaction> byTypeAndMinAndMax(String type, double minAmount, double maxAmount);
}
