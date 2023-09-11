package devdojo.exam.transactions.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import devdojo.exam.transactions.domain.BankTransaction;

import java.io.IOException;

public class CustomSerializer extends JsonSerializer<BankTransaction> {

    @Override
    public void serialize(BankTransaction transaction, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("id", transaction.getEncodedKey());
        jsonGenerator.writeStringField("counterPartyAccountNumber", transaction.getCounterPartyAccountNumber());
        jsonGenerator.writeStringField("valueDate", transaction.getValueDate());
        jsonGenerator.writeStringField("bookingDate", transaction.getBookingDate());
        jsonGenerator.writeStringField("arrangementId", transaction.getArrangementId());
        jsonGenerator.writeStringField("currency", transaction.getCurrency());
        jsonGenerator.writeStringField("currencyCode", transaction.getCurrencyCode());
        jsonGenerator.writeNumberField("amount", transaction.getAmount());
        jsonGenerator.writeNumberField("creditDebitIndicator", transaction.getCreditDebitIndicator());
        jsonGenerator.writeNumberField("instructedAmount", transaction.getInstructedAmount());
        jsonGenerator.writeStringField("typeGroup", transaction.getTypeGroup());
        jsonGenerator.writeStringField("type", transaction.getType());
        jsonGenerator.writeStringField("reference", transaction.getReference());
        jsonGenerator.writeNumberField("runningBalance", transaction.getRunningBalance());
        jsonGenerator.writeEndObject();
    }
}