package com.angrybeard.grumbler;

/*
Бот для нотификаций в Слак
Собран на базе репозитория dogeared/magic-with-slack-and-twilio
https://github.com/dogeared/magic-with-slack-and-twilio
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class GrumblerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrumblerApplication.class, args);
	}
}

