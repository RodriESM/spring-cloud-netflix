package org.rodriesm.springboot.maven.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

//Hay que instanciarla
@EnableCircuitBreaker
//Indicamos que es un cliente de Eureka
@EnableEurekaClient
//Anotar con este cliente para administrar el microservicio, con Eureka desaparece
//@RibbonClient(name = "servicio-productos")
//Importante para habilitar nuestros clientes feign y nos permite inyectar estos clientes en los componentes Spring
@EnableFeignClients
@SpringBootApplication
public class SpringBootCloudItemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCloudItemApplication.class, args);
	}

}
