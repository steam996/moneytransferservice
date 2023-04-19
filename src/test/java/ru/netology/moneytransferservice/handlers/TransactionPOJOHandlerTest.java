package ru.netology.moneytransferservice.handlers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.moneytransferservice.model.Transaction;
import ru.netology.moneytransferservice.model.TransactionPOJO;

import java.util.HashMap;
import java.util.Map;

class TransactionPOJOHandlerTest {
    CardToCardHandler handler = new CardToCardHandler();
    Map<String, Object> amount = new HashMap<>();

    @Test
    void handle() {
        amount.put("value", "100000");
        amount.put("currency", "RUR");
        TransactionPOJO transactionPOJO = new TransactionPOJO("1321 3168 5166 5161",
                "12/34", "156", "7897 4916 5416 9841", amount);
        Transaction transaction = handler.handle(transactionPOJO);
        Assertions.assertEquals("1321 3168 5166 5161", transaction.getCardFromNumber());
        Assertions.assertEquals("12/34", transaction.getCardFromValidTill());
        Assertions.assertEquals("156", transaction.getCardFromCVV());
        Assertions.assertEquals("7897 4916 5416 9841", transaction.getCardToNumber());
        Assertions.assertEquals(100_000, transaction.getValue());
        Assertions.assertEquals("RUR", transaction.getCurrency());
    }
}