package com.arjun.springSecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity

public class SecurityConfig {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(request -> {
                    request.requestMatchers("/myAccount", "/myBalance", "/myCards", "/myCards").authenticated()
                            .requestMatchers("/notices", "/contact","/register").permitAll()
                            .anyRequest().authenticated();

                }).httpBasic(Customizer.withDefaults()).csrf(csrf -> csrf.disable());

        return http.build();
    }
//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager (){
//        UserDetails admin = User.withUsername("admin")
//                .password("12345").authorities("admin").build();
//        UserDetails user = User.withUsername("user")
//                .password("12345").authorities("read").build();
//
//
////UserDetails admin = User.withDefaultPasswordEncoder().username("admin")
////                .password("12345").authorities("admin").build();
////        UserDetails user = User.withDefaultPasswordEncoder().username("user")
////                .password("12345").authorities("read").build();
//
//        return new InMemoryUserDetailsManager(admin,user);
//    }







//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return NoOpPasswordEncoder.getInstance(); //NoOpPasswordEncoder is a password encoder that performs no encoding at all.
//    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(); //NoOpPasswordEncoder is a password encoder that performs no encoding at all.
    }


}
