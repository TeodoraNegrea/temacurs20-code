package ro.fasttrackit.temacurs20.controller;

import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.temacurs20.entity.Transaction;
import ro.fasttrackit.temacurs20.service.TransactionService;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("transactions")
@RestController
public class TransactionController {
    private final TransactionService service;

    public TransactionController(TransactionService service){
        this.service = service;
    }
    @GetMapping
    public List<Transaction> getAll(){
        return service.getAll()
                .stream()
                .collect(Collectors.groupingBy(Transaction::getType))
                .get(service);

    }
    @PostMapping
    Transaction addOne(@RequestBody Transaction transaction){
        return service.addOne(transaction);
    }
    @GetMapping("transactions/{id}")
    Optional<Transaction> getId(@PathVariable int id) {
        return service.getById(id);
    }

    @PutMapping("{id}")
    Optional<Transaction> replace(@PathVariable int id, @RequestBody Transaction transaction) {
        return service.replaceTransaction(id, transaction);
    }

    @DeleteMapping("{id}")
    Transaction delete(@PathVariable int id) {
        return service.deleteTransaction(id);
    }

}
