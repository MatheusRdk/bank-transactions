package devdojo.exam.transactions.config;

import devdojo.exam.transactions.repository.BankUserRepository;
import devdojo.exam.transactions.service.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final BankUserRepository bankUserRepository;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests((authorize) -> authorize.anyRequest().authenticated()
                ).httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public CustomUserDetailsService customUserDetailsService(){
        return new CustomUserDetailsService(bankUserRepository);
    }
}
