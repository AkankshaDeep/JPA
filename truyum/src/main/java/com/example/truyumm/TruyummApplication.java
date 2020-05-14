package com.example.truyumm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.example.truyumm.controller","com.example.truyumm.model","com.example.truyumm.dao","com.example.truyumm.repository"})
@SpringBootApplication
public class TruyummApplication {

	public static void main(String[] args) {
		SpringApplication.run(TruyummApplication.class, args);
	}

}
