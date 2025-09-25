package dev.slapps.web_security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebSecurityApplication {

	public static void main(String[] args) {
		System.out.println("WebSecurityApplication.main()");
		SpringApplication.run(WebSecurityApplication.class, args);
	}

}
