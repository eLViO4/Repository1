package com.springBoot.e.springBoot.e.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    private final DataSource dataSource;

    public SecurityConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

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
        return new JdbcUserDetailsManager(dataSource);


       /* InMemoryUserDetailsManager imudm = new InMemoryUserDetailsManager();

        imudm.createUser(User.withUsername("admin").password("{noop}admin").roles("ADMIN").build());

        imudm.createUser(User.withUsername("manager1").password("{noop}manager").roles("MANAGER").build());
        imudm.createUser(User.withUsername("manager2").password("{noop}manager").roles("MANAGER").build());
        imudm.createUser(User.withUsername("manager3").password("{noop}manager").roles("MANAGER").build());

        imudm.createUser(User.withUsername("editor1").password("{noop}editor").roles("EDITOR").build());
        imudm.createUser(User.withUsername("editor2").password("{noop}editor").roles("EDITOR").build());
        imudm.createUser(User.withUsername("editor3").password("{noop}editor").roles("EDITOR").build());
        imudm.createUser(User.withUsername("editor4").password("{noop}editor").roles("EDITOR").build());
        imudm.createUser(User.withUsername("editor5").password("{noop}editor").roles("EDITOR").build());

        imudm.createUser(User.withUsername("user1").password("{noop}user").roles("USER").build());
        imudm.createUser(User.withUsername("user2").password("{noop}user").roles("USER").build());
        imudm.createUser(User.withUsername("user3").password("{noop}user").roles("USER").build());
        imudm.createUser(User.withUsername("user4").password("{noop}user").roles("USER").build());
        imudm.createUser(User.withUsername("user5").password("{noop}user").roles("USER").build());
        imudm.createUser(User.withUsername("user6").password("{noop}user").roles("USER").build());
        imudm.createUser(User.withUsername("user7").password("{noop}user").roles("USER").build());
        imudm.createUser(User.withUsername("user8").password("{noop}user").roles("USER").build());
        imudm.createUser(User.withUsername("user9").password("{noop}user").roles("USER").build());
        imudm.createUser(User.withUsername("user10").password("{noop}user").roles("USER").build());

        return imudm;*/
    }

    /*@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }*/
}
