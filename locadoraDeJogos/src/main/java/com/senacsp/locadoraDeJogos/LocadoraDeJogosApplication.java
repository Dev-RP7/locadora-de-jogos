package com.senacsp.locadoraDeJogos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class LocadoraDeJogosApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocadoraDeJogosApplication.class, args);
	}

}
