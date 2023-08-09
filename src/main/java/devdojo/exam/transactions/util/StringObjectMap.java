package devdojo.exam.transactions.util;

import devdojo.exam.transactions.domain.BankTransaction;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class StringObjectMap {
    public static Map<String, Object> getStringObjectMap(BankTransaction transaction) {
        Map<String, Object> customTransaction = new LinkedHashMap<>();
        customTransaction.put("id", transaction.getEncodedKey());
        customTransaction.put("counterPartyAccountNumber", transaction.getCounterPartyAccountNumber());
        customTransaction.put("valueDate", transaction.getValueDate());
        customTransaction.put("bookingDate", transaction.getBookingDate());
        customTransaction.put("arrangementId", transaction.getArrangementId());
        customTransaction.put("currency", transaction.getCurrency());
        customTransaction.put("currencyCode", transaction.getCurrencyCode());
        customTransaction.put("amount", transaction.getAmount());
        customTransaction.put("creditDebitIndicator", transaction.getCreditDebitIndicator());
        customTransaction.put("instructedAmount", transaction.getInstructedAmount());
        customTransaction.put("typeGroup", transaction.getTypeGroup());
        customTransaction.put("type", transaction.getType());
        customTransaction.put("reference", transaction.getReference());
        customTransaction.put("runningBalance", transaction.getRunningBalance());
        return customTransaction;
    }
}
