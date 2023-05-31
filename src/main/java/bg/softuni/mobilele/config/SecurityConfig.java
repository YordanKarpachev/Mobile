package bg.softuni.mobilele.config;


import bg.softuni.mobilele.repository.UserRepository;
import bg.softuni.mobilele.service.MobileUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

@Configuration

public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
     return new Pbkdf2PasswordEncoder();
    }

    @Bean
    UserDetailsService userDetailsService(UserRepository userRepository){
        return new MobileUserDetailsService(userRepository);
    }

}
