package devdojo.exam.transactions.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AccountBalances {
    @JsonProperty("totalBalance")
    private double runningBalance;
}
