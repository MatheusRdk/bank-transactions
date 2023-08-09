package devdojo.exam.transactions.service;

import devdojo.exam.transactions.domain.BankUser;
import devdojo.exam.transactions.repository.BankUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

import javax.sql.DataSource;

@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final BankUserRepository bankUserRepository;

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Override
    public UserDetails loadUserByUsername(String username){
        BankUser bankUser = bankUserRepository.findByUsername(username);
        if (bankUser == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return User.builder()
                .username(bankUser.getUsername())
                .password("{noop}" + bankUser.getPassword())
                .roles("USER")
                .build();
    }
}
