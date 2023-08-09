package devdojo.exam.transactions.requests;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BankUserPutRequestBody {
    private Long id;

    private String username;
}

