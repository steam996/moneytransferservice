package ru.netology.moneytransferservice.controller;


import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.moneytransferservice.model.Code;
import ru.netology.moneytransferservice.model.Transaction;
import ru.netology.moneytransferservice.model.TransactionPOJO;
import ru.netology.moneytransferservice.service.TransactionService;

@CrossOrigin
@RestController
public class TransactionController {

    private final TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }


    @PostMapping("/transfer")
    public Transaction transfer(@RequestBody @Valid TransactionPOJO operation) {
        return service.saveTransaction(operation);
    }


    @PostMapping("/confirmOperation")
    public Transaction confirm(@RequestBody @Valid Code code) {
        return service.saveCode(code);
    }


}
