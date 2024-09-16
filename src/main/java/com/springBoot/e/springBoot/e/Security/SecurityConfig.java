package com.springBoot.e.springBoot.e.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                        .requestMatchers(HttpMethod.GET, "/cars").hasAnyRole("ADMIN", "USER", "MANAGER")
                        .requestMatchers(HttpMethod.POST, "/cars").hasAnyRole("ADMIN", "MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/cars").hasAnyRole("ADMIN", "EDITOR")
                        .requestMatchers(HttpMethod.DELETE, "/cars/{id}").hasAnyRole("ADMIN", "MANAGER")
                        .anyRequest().permitAll()
                )
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())
                .csrf(csrf -> csrf.disable());

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("user1").password("{noop}user").roles("USER").build());
        manager.createUser(User.withUsername("admin1").password("{noop}admin").roles("ADMIN").build());
        manager.createUser(User.withUsername("manager1").password("{noop}manager").roles("MANAGER").build());
        manager.createUser(User.withUsername("editor1").password("{noop}editor").roles("EDITOR").build());
        return manager;
    }

    /*@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Шифрование паролей
    }*/
}
