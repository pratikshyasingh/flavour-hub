package edu.rims.flavour_hub.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                request -> request
                        .requestMatchers("/customer/login", "/style/**", "/script/**", "/images/**", "/customer",
                                "/customer/category/plp", "/customer/food_item/pdp", "/*/image/*", "/product/search")
                        .permitAll()
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .anyRequest().authenticated());
        http.formLogin(form -> form.loginPage("/customer/login"));
        http.logout(Customizer.withDefaults());
        return http.build();
    }

}
