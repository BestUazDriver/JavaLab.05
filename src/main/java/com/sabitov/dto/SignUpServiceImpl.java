package com.sabitov.dto;

import org.springframework.stereotype.Service;

@Service
public class SignUpServiceImpl implements SignUpService {
    @Override
    public void signUp(SignUpForm signUpForm) {
        System.out.println(signUpForm);
    }
}
