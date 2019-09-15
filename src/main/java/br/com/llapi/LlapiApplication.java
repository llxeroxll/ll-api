package br.com.llapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableCaching
public class LlapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LlapiApplication.class, args);
	}

}
