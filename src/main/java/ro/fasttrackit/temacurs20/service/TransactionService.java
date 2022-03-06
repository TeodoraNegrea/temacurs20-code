package ro.fasttrackit.temacurs20.service;

import org.springframework.stereotype.Service;
import ro.fasttrackit.temacurs20.entity.Transaction;
import ro.fasttrackit.temacurs20.repository.TransactionRepository;

import java.util.List;
import java.util.Optional;
import java.util.function.DoubleConsumer;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

@Service
public class TransactionService {
    private final TransactionRepository repository;

    private TransactionService(TransactionRepository repository){
    this.repository = repository;
    }

    public Optional<Transaction> getMinAmount(double amount){
        return Optional.of(repository.findAll()
                .stream().min((d1, d2) -> Double.compare(d1.getAmount(), d2.getAmount()))
                .get());
    }
    public Optional<Transaction> getMaxAmount(double amount) {
        return Optional.of(repository.findAll()
                .stream().max((d1, d2) -> Double.compare(d1.getAmount(), d2.getAmount()))
                .get());
    }
    public List<Transaction> getAll(){
        return repository.findAll();
    }
    public Transaction addOne(Transaction transaction){
       return  repository.save(transaction);
    }
    public Optional<Transaction> getById(int id){
        return repository.findById(id);
    }
    public Optional<Transaction> replaceTransaction(int id, Transaction transaction) {
        return getById(id)
                .map(existing -> repository.save(transaction));
    }
    public Transaction deleteTransaction(int id){
        return repository.findAll().remove(id);
    }
}
