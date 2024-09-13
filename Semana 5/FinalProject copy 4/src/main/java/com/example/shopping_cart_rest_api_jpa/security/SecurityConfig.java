package com.example.shopping_cart_rest_api_jpa.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authz -> authz
                // Allow clients to view (GET) items but restrict modifications (POST, PUT, DELETE)

                .requestMatchers("/shop/items").permitAll()  // Client can access

                .requestMatchers("/shop/**").hasRole("ADMIN")  // Admin-only access

                .anyRequest().authenticated()  // All other requests need authentication
            )
            .httpBasic(withDefaults())  // Enable basic HTTP authentication
            .csrf(csrf -> csrf.disable());  // Disable CSRF protection for simplicity

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        // Define admin and client users with encoded passwords
        UserDetails admin = User.withUsername("admin")
                .password(passwordEncoder.encode("admin"))  // Encode password
                .roles("ADMIN")
                .build();

        UserDetails client = User.withUsername("client")
                .password(passwordEncoder.encode("client"))  // Encode password
                .roles("CLIENT")
                .build();

        return new InMemoryUserDetailsManager(admin, client);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // Use BCrypt for password encoding
    }
}
