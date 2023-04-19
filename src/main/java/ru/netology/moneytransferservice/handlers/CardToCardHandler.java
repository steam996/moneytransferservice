package ru.netology.moneytransferservice.handlers;

import ru.netology.moneytransferservice.model.Transaction;
import ru.netology.moneytransferservice.model.TransactionPOJO;

public class CardToCardHandler {

    public Transaction handle(TransactionPOJO operation) {
        return new Transaction(operation.getCardFromNumber(), operation.getCardFromValidTill(),
                operation.getCardFromCVV(), operation.getCardToNumber(),
                operation.getValue(), operation.getCurrency());
    }
}
