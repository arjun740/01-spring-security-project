package com.arjun.springSecurity.config;

import com.arjun.springSecurity.model.Customer;
import com.arjun.springSecurity.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class BankAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        Customer foundCustomer = customerRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Invalid username "));

        if (!passwordEncoder.matches(password, foundCustomer.getPwd())) {
            throw new BadCredentialsException("Invalid credentials");
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(foundCustomer.getRole()));  // Consider using AuthorityImpl or a custom implementation

        return new UsernamePasswordAuthenticationToken(
                username, password, authorities);
    }



    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
        /*
        * This method determines whether a given authentication provider is capable of handling a specific type of authentication token.
        It acts as a filter, ensuring that authentication requests are directed to the appropriate provider based on their token type.
        **/
    }
}
