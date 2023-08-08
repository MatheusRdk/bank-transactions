package devdojo.exam.transactions.service;

import devdojo.exam.transactions.domain.BankTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.util.List;

@ExtendWith(SpringExtension.class)
public class BankServiceTest {
    @InjectMocks
    private BankService bankService;


    @Test
    public void testGetTransactions() throws IOException {
        String filePath = "resources/transactions.json";

        List<BankTransaction> transactions = bankService.getTransactions(filePath);

        Assertions.assertFalse(transactions.isEmpty());
        Assertions.assertEquals(14, transactions.size());
    }
}
