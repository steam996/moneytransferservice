package ru.netology.moneytransferservice.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.moneytransferservice.model.Code;
import ru.netology.moneytransferservice.model.Transaction;
import ru.netology.moneytransferservice.model.TransactionPOJO;

class TransactionRepositoryTest {

    TransactionRepository repository = new TransactionRepository();
    TransactionPOJO transactionPOJOMock = Mockito.mock(TransactionPOJO.class);
    Code codeMock = Mockito.mock(Code.class);


    @Test
    void saveTransactionTest() {
        Transaction transaction = repository.saveTransaction(transactionPOJOMock);
        int id = transaction.getId();
        Assertions.assertEquals(1, id);
    }

    @Test
    void saveCode() {
        Mockito.when(codeMock.getOperationId()).thenReturn(1);
        Mockito.when(codeMock.getCode()).thenReturn("0000");
        repository.saveTransaction(transactionPOJOMock);
        Transaction transaction = repository.saveCode(codeMock);
        Assertions.assertEquals("0000", transaction.getCode());
    }
}