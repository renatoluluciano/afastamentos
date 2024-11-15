package com.afastamentos.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

@Configurable
public class Configuration {
    @Bean
    ModelMapper modelMapper(){
        return new ModelMapper();
    }

}
