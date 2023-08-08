package devdojo.exam.transactions.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import devdojo.exam.transactions.domain.BankTransaction;
import devdojo.exam.transactions.domain.BankUser;
import devdojo.exam.transactions.repository.BankUserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class BankService {

    private final BankUserRepository bankUserRepository;

    private String readJson(String filePath) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
        }
        return stringBuilder.toString();
    }

    public List<BankTransaction> getTransactions(String filePath) throws IOException {
        String jsonContent = readJson(filePath);

        ObjectMapper objectMapper = new ObjectMapper();


        return objectMapper.readValue(
                jsonContent,
                new TypeReference<List<BankTransaction>>() {
                }
        );
    }

    @Transactional
    public void randomTransactionToUser(BankUser user) throws IOException {
        List<BankTransaction> transactions = getTransactions("resources/transactions.json");

        Random random = new Random();
        int randomIndex = random.nextInt(transactions.size());

        BankTransaction selectedTransaction = transactions.get(randomIndex);

        List<BankUser> bankUsersList = bankUserRepository.findAll();

        for (BankUser bankUser : bankUsersList) {
            if (bankUser.getTransactionsEncodedKeys().contains(selectedTransaction.getEncodedKey())) {
                throw new IllegalStateException("Transaction already associated with the user.");
            }
        }

        if (user.getTransactionsEncodedKeys() == null) {
            user.setTransactionsEncodedKeys(new ArrayList<>());
        }

        user.getTransactionsEncodedKeys().add(selectedTransaction.getEncodedKey());

        bankUserRepository.save(user);
    }
}
