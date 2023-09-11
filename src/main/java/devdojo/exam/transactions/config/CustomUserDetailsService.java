package devdojo.exam.transactions.config;

import devdojo.exam.transactions.domain.BankUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class CustomUserDetailsService implements UserDetailsService {
    private List<UserDetails> users = new ArrayList<>();

    public CustomUserDetailsService() {

        users.add(BankUser.USER1);

        users.add(BankUser.USER2);

        users.add(BankUser.USER3);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        for (UserDetails user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        throw new UsernameNotFoundException("Usuário não encontrado");
    }
}
