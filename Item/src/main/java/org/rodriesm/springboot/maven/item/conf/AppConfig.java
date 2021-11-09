package org.rodriesm.springboot.maven.item.conf;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

//Esta clase nos permite crear beans y utilizarlos en otros sitios
@Configuration
public class AppConfig {

    //Es un cliente http para poder acceder a recursos que estan en otro microservicios
    @Bean("productRest")
    @LoadBalanced
    public RestTemplate registrarRestTemplate(){
        return new RestTemplate();
    }
}
