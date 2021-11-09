package org.rodriesm.springboot.maven.cinemaclub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//Indicamos que es un cliente de Eureka
@EnableEurekaClient
@SpringBootApplication
public class SpringBootCloudCinemaClubApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCloudCinemaClubApplication.class, args);
	}

}
