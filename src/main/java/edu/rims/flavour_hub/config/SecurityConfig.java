package edu.rims.flavour_hub.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import edu.rims.flavour_hub.entity.User;
import edu.rims.flavour_hub.repository.UserRepository;

@Configuration
public class SecurityConfig {
    @Autowired
    private UserRepository userRepository;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                request -> request
                        .requestMatchers("/customer/login", "/style/**", "/script/**", "/images/**", "/customer",
                                "/customer/category/plp", "/customer/food_item/pdp", "/*/image/*", "/product/search",
                                "/customer/sign-up")
                        .permitAll()
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .anyRequest().authenticated());
        http.formLogin(form -> form.loginPage("/customer/login").defaultSuccessUrl("/customer"));
        http.logout(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    PasswordEncoder encoder() {
        return new BCryptPasswordEncoder(12);
    }

    @Bean
    UserDetailsService detailsService() {
        return (username) -> {
            User user = userRepository.findByUserEmail(username)
                    .orElseThrow(() -> new UsernameNotFoundException("userNotFound"));
            return org.springframework.security.core.userdetails.User.builder()
                    .username(username)
                    .password(user.getUserPassword())
                    .roles(user.getUserRole().toString())
                    .build();
        };

    }

}
