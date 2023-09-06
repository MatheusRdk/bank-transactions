package devdojo.exam.transactions.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BankUser implements UserDetails {
    public static BankUser USER1 = BankUser.builder()
            .username("User1")
            .password(passwordEncoder().encode("test"))
            .accountId(1)
            .transactionsEncodedKeys(new ArrayList<>(List.of("8a8586c5718588a20171881b4bc86de3", "8a85871771857bc501718816e2c808ce", "8a8587d8715f11960171641114d26003")))
            .authorities(List.of(new SimpleGrantedAuthority("ROLE_USER"), new SimpleGrantedAuthority("ROLE_ADMIN")))
            .build();

    public static BankUser USER2 = BankUser.builder()
            .username("User2")
            .password(passwordEncoder().encode("test"))
            .accountId(2)
            .transactionsEncodedKeys(new ArrayList<>(List.of("8a8587f7715f08260171636de170588f", "8a85879c715957a6017159875482105a", "8a85866f7155205601715987552476ec")))
            .authorities(List.of(new SimpleGrantedAuthority("ROLE_USER")))
            .build();

    public static BankUser USER3 = BankUser.builder()
            .username("User3")
            .password(passwordEncoder().encode("test"))
            .accountId(3)
            .transactionsEncodedKeys(new ArrayList<>(List.of("8a8587506b566dfd016b5adf5d4444f0", "8a8587506b566dfd016b5ae15b6644f8", "8a8587506b566dfd016b5ae0492944f2")))
            .authorities(List.of(new SimpleGrantedAuthority("ROLE_USER")))
            .build();

    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    private Collection<? extends GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return authorities;
    }

    private int accountId;

    private String username;

    private List<String> transactionsEncodedKeys;

    private String password;

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}