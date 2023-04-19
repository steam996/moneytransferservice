package ru.netology.moneytransferservice.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.moneytransferservice.model.Transaction;
import ru.netology.moneytransferservice.model.TransactionPOJO;
import ru.netology.moneytransferservice.repository.TransactionRepository;

class TransactionServiceTest {
    TransactionRepository repository = Mockito.mock(TransactionRepository.class);
    TransactionService service = new TransactionService(repository);

    TransactionPOJO cardMock = Mockito.mock(TransactionPOJO.class);
    Transaction transaction = Mockito.mock(Transaction.class);

    @Test
    void saveTransaction() {
        Mockito.when(repository.saveTransaction(cardMock)).thenReturn(transaction);
        Transaction transaction1 = service.saveTransaction(cardMock);
        Assertions.assertEquals(transaction, transaction1);
    }

    @Test
    void saveCode() {
        Mockito.when(repository.saveTransaction(cardMock)).thenReturn(transaction);
        Transaction transaction1 = service.saveTransaction(cardMock);
        Assertions.assertEquals(transaction, transaction1);
    }
}