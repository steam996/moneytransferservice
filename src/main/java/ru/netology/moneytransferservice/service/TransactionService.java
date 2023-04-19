package ru.netology.moneytransferservice.service;


import org.springframework.stereotype.Service;
import ru.netology.moneytransferservice.model.TransactionPOJO;
import ru.netology.moneytransferservice.model.Code;
import ru.netology.moneytransferservice.model.Transaction;
import ru.netology.moneytransferservice.repository.TransactionRepository;

@Service
public class TransactionService {
    private final TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    public Transaction saveTransaction (TransactionPOJO operation){
        return repository.saveTransaction(operation);
    }

    public Transaction saveCode (Code code){
        return repository.saveCode(code);
    }
}
