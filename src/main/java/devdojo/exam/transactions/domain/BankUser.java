package devdojo.exam.transactions.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class BankUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Name cannot be empty.")
    private String username;

    @ElementCollection
    private List<String> transactionsEncodedKeys;

    @NotEmpty(message = "Password cannot be empty.")
    private String password;
}