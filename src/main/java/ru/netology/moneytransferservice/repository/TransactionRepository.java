package ru.netology.moneytransferservice.repository;


import org.springframework.stereotype.Repository;
import ru.netology.moneytransferservice.handlers.CardToCardHandler;
import ru.netology.moneytransferservice.handlers.Logger;
import ru.netology.moneytransferservice.model.Code;
import ru.netology.moneytransferservice.model.Transaction;
import ru.netology.moneytransferservice.model.TransactionPOJO;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class TransactionRepository {
    private CardToCardHandler handler = new CardToCardHandler();
    private Map<Integer, Transaction> transactionMap = new HashMap<>();
    private AtomicInteger idCount = new AtomicInteger();

    public Transaction saveTransaction(TransactionPOJO operation) {
        int id = idCount.incrementAndGet();
        Transaction transaction = handler.handle(operation);
        transaction.setId(id);
        transactionMap.put(id, transaction);
        Logger.getInstance().log(transaction.toString());
        return transaction;
    }

    public Transaction saveCode(Code code) {
        int id = code.getOperationId();
        Transaction transaction = transactionMap.get(id);
        transaction.setCode(code.getCode());
        Logger.getInstance().log(code.toString());
        return transaction;
    }
}
