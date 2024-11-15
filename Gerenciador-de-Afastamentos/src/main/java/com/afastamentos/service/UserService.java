package com.afastamentos.service;

import org.springframework.stereotype.Service;

import com.afastamentos.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

}
