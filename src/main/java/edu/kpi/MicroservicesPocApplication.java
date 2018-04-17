package edu.kpi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class MicroservicesPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesPocApplication.class, args);
	}
}
