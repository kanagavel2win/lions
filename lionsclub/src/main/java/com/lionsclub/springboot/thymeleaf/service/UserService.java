package com.lionsclub.springboot.thymeleaf.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.lionsclub.springboot.thymeleaf.entity.User;
import com.lionsclub.springboot.thymeleaf.entity.UserRegistrationDto;


public interface UserService extends UserDetailsService {

    User findByEmail(String email);
    User findByMemberID(String memberID);

    User save(UserRegistrationDto registration);
	UserDetails loadUserByUsername(String email) throws UsernameNotFoundException;
}
