package devdojo.exam.transactions.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import devdojo.exam.transactions.domain.BankTransaction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class ReadJson {
    private static final String file = "resources/transactions.json";

    public static List<BankTransaction> getTransactions() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
        }

        String jsonContent = stringBuilder.toString();

        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(
                jsonContent,
                new TypeReference<List<BankTransaction>>() {
                }
        );
    }
}
