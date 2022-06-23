package com.example.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.LoggerFactory;
import ch.qos.logback.classic.Logger;


@SpringBootApplication
public class DemoApplication {
	private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		LOGGER.info("An INFO Message");
		LOGGER.warn("An WARN Message");
	}

}
