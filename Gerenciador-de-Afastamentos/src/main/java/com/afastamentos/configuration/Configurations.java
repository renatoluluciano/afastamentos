package com.afastamentos.configuration;

import org.modelmapper.ModelMapper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration

public class Configurations {
    @Bean
    ModelMapper modelMapper(){
        return new ModelMapper();
    }

}
