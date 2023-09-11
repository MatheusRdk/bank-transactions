package devdojo.exam.transactions.service;

import devdojo.exam.transactions.domain.BankTransaction;
import devdojo.exam.transactions.domain.BankUser;
import devdojo.exam.transactions.util.ReadJson;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BankService {
    public ResponseEntity<List<BankTransaction>> responseForAccountId(long accountId) throws IOException {

        BankUser bankUser = (BankUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        List<BankTransaction> transactions = ReadJson.getTransactions();

        List<BankTransaction> transactionsResponse = new ArrayList<>();

        for (BankTransaction transaction : transactions) {
            if (bankUser.getTransactionsEncodedKeys().contains(transaction.getEncodedKey())) {
                transactionsResponse.add(transaction);
            }
        }
        return new ResponseEntity<>(transactionsResponse, HttpStatus.OK);
    }

    public ResponseEntity<List<BankTransaction>> responseAll() throws IOException {
        List<BankTransaction> transactions = ReadJson.getTransactions();
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }
}