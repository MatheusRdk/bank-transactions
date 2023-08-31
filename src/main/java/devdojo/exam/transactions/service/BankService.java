package devdojo.exam.transactions.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import devdojo.exam.transactions.config.SecurityConfig;
import devdojo.exam.transactions.domain.BankTransaction;
import devdojo.exam.transactions.domain.BankUser;
import devdojo.exam.transactions.util.StringObjectMap;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class BankService {

    private static final Logger logger = LoggerFactory.getLogger(SecurityConfig.class);

    private static final String file = "resources/transactions.json";

    private static String readJson() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
        }
        return stringBuilder.toString();
    }

    public static List<BankTransaction> getTransactions() throws IOException {
        String jsonContent = readJson();

        ObjectMapper objectMapper = new ObjectMapper();


        return objectMapper.readValue(
                jsonContent,
                new TypeReference<List<BankTransaction>>() {
                }
        );
    }

    public ResponseEntity<List<Map<String, Object>>> customReponseForAccountId(long accountId) throws IOException {
        List<BankTransaction> transactions = getTransactions();
        BankUser bankUser = new BankUser();
        for (BankUser user : BankUser.getAllUsers()){
            if (user.getAccountId() == accountId){
                bankUser = user;
            }
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        List<Map<String, Object>> customResponse = new ArrayList<>();

        if (!userDetails.getUsername().equals(bankUser.getUsername())) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        for (BankTransaction transaction : transactions) {
            if (bankUser.getTransactionsEncodedKeys().contains(transaction.getEncodedKey())) {
                addExtractedTransactionToCustomResponse(customResponse, transaction);
            }
        }
        return new ResponseEntity<>(customResponse, HttpStatus.OK);
    }

    public ResponseEntity<List<Map<String, Object>>> customReponseAll() throws IOException {
        List<BankTransaction> transactions = getTransactions();
        List<Map<String, Object>> customResponse = new ArrayList<>();
        for (BankTransaction transaction : transactions) {
            addExtractedTransactionToCustomResponse(customResponse, transaction);
        }
        return new ResponseEntity<>(customResponse, HttpStatus.OK);
    }

    public void addExtractedTransactionToCustomResponse(List<Map<String, Object>> customResponse, BankTransaction transaction) {
        Map<String, Object> customTransaction = StringObjectMap.getStringObjectMap(transaction);
        customResponse.add(customTransaction);
    }
}
