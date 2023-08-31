package devdojo.exam.transactions.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BankUser {
    public static BankUser USER1 = BankUser.builder()
            .username("User1")
            .password("test")
            .accountId(1)
            .transactionsEncodedKeys(new ArrayList<>(List.of("8a8586c5718588a20171881b4bc86de3", "8a85871771857bc501718816e2c808ce", "8a8587d8715f11960171641114d26003")))
            .build();

    public static BankUser USER2 = BankUser.builder()
            .username("User2")
            .password("test")
            .accountId(2)
            .transactionsEncodedKeys(new ArrayList<>(List.of("8a8587f7715f08260171636de170588f", "8a85879c715957a6017159875482105a", "8a85866f7155205601715987552476ec")))
            .build();

    public static BankUser USER3 = BankUser.builder()
            .username("User3")
            .password("test")
            .accountId(3)
            .transactionsEncodedKeys(new ArrayList<>(List.of("8a8587506b566dfd016b5adf5d4444f0", "8a8587506b566dfd016b5ae15b6644f8", "8a8587506b566dfd016b5ae0492944f2")))
            .build();

    public static List<BankUser> getAllUsers(){
        return new ArrayList<>(List.of(USER1, USER2, USER3));
    }

    private int accountId;

    private String username;

    private List<String> transactionsEncodedKeys;

    private String password;
}