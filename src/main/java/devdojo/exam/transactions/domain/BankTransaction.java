package devdojo.exam.transactions.domain;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BankTransaction {
    @JsonProperty("encodedKey")
    private String id;

    @JsonProperty("parentAccountKey")
    private String parentAccountKey;

    @JsonProperty("creationDate")
    private String bookingDate;

    @JsonProperty("type")
    private String type;

    private String valueDate;

    @JsonProperty("amount")
    private double amount;

    @JsonProperty("currencyCode")
    private String currencyCode;

    private String currency;

    private double creditDebitIndicator;

    @JsonProperty("accountBalances.totalBalance")
    private double runningBalance;

    @JsonProperty("id")
    private String counterPartyAccountNumber;

    private String typeGroup;

    private double instructedAmount;

    public String getReference() {
        return parentAccountKey;
    }
    public String getArrangementId() {
        return parentAccountKey;
    }

    public String getTypeGroup(){
        return type;
    }

    public String getCurrency(){
        return currencyCode;
    }

    public double getCreditDebitIndicator(){
        return amount;
    }

    public double getInstructedAmount(){
        return amount;
    }
}
