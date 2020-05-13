package com.lionsclub.springboot.thymeleaf.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.lionsclub.springboot.thymeleaf.entity.User;
import com.lionsclub.springboot.thymeleaf.entity.UserRegistrationDto;


public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);
}
