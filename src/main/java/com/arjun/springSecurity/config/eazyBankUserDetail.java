package com.arjun.springSecurity.config;

import com.arjun.springSecurity.model.Customer;
import com.arjun.springSecurity.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@Service
//public class eazyBankUserDetail implements UserDetailsService {
//
//    @Autowired
//    private CustomerRepository customerRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//       String userName, password;
//        List<GrantedAuthority> authorities ;
//        Optional<Customer> customer = customerRepository.findByEmail(username);
//        if(customer.isEmpty()){
//            throw  new UsernameNotFoundException("User detail not found for the user name "+ username);
//        }
//        else {
//            Customer foundCustomer = customer.get();
//            userName = foundCustomer.getEmail();
//            password = foundCustomer.getPwd();
//            authorities = new ArrayList<>();
//            authorities.add(new SimpleGrantedAuthority(foundCustomer.getRole()));
//        }
//        return new User(userName, password, authorities);
//    }
//}
