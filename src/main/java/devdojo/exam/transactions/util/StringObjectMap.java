package devdojo.exam.transactions.util;

import devdojo.exam.transactions.domain.BankTransaction;

import java.util.HashMap;
import java.util.Map;

public class StringObjectMap {
    public static Map<String, Object> getStringObjectMap(BankTransaction transaction) {
        Map<String, Object> customTransaction = new HashMap<>();
        customTransaction.put("valueDate", transaction.getValueDate());
        customTransaction.put("arrangementId", transaction.getArrangementId());
        customTransaction.put("currency", transaction.getCurrency());
        customTransaction.put("creditDebitIndicator", transaction.getCreditDebitIndicator());
        customTransaction.put("typeGroup", transaction.getTypeGroup());
        customTransaction.put("instructedAmount", transaction.getInstructedAmount());
        customTransaction.put("reference", transaction.getReference());
        customTransaction.put("bookingDate", transaction.getBookingDate());
        customTransaction.put("type", transaction.getType());
        customTransaction.put("amount", transaction.getAmount());
        customTransaction.put("currencyCode", transaction.getCurrencyCode());
        customTransaction.put("runningBalance", transaction.getRunningBalance());
        customTransaction.put("counterPartyAccountNumber", transaction.getCounterPartyAccountNumber());
        customTransaction.put("id", transaction.getEncodedKey());
        return customTransaction;
    }
}
