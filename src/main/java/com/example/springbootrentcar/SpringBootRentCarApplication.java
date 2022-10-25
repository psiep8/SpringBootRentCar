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

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRentCarApplication.class, args);
    }

}
