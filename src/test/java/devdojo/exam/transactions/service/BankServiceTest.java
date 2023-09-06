package devdojo.exam.transactions.service;

import devdojo.exam.transactions.domain.BankTransaction;
import devdojo.exam.transactions.util.ReadJson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.util.List;

@ExtendWith(SpringExtension.class)
public class BankServiceTest {

    @Test
    public void testGetTransactions() throws IOException {

        List<BankTransaction> transactions = ReadJson.getTransactions();

        Assertions.assertFalse(transactions.isEmpty());
        Assertions.assertEquals(14, transactions.size());
        System.out.println(transactions);
    }
}
