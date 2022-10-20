package com.example.springbootrentcar;

import com.example.springbootrentcar.mapper.AutoMapper;
import com.example.springbootrentcar.mapper.PrenotazioneMapper;
import com.example.springbootrentcar.mapper.UtenteMapper;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class SpringBootRentCarApplication {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public UtenteMapper utenteMapper() {
        return new UtenteMapper(modelMapper());
    }

    @Bean
    public PrenotazioneMapper prenotazioneMapper() {
        return new PrenotazioneMapper(modelMapper());
    }

    @Bean
    public AutoMapper autoMapper() {
        return new AutoMapper(modelMapper());
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRentCarApplication.class, args);
    }

}
