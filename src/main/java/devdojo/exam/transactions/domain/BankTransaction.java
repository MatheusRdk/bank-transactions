package devdojo.exam.transactions.domain;


import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import devdojo.exam.transactions.util.CustomSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonSerialize(using = CustomSerializer.class)
public class BankTransaction {

    @JsonProperty("encodedKey")
    private String encodedKey;

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

    private AccountBalances accountBalances;

    @JsonProperty("id")
    private String counterPartyAccountNumber;

    private String typeGroup;

    private double instructedAmount;

    @JsonGetter("runningBalance")
    public double getRunningBalance() {
        if (accountBalances != null) {
            return accountBalances.getRunningBalance();
        }
        return 0.0;
    }

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
