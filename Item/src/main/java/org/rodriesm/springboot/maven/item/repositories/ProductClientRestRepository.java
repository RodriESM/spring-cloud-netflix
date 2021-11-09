package org.rodriesm.springboot.maven.item.repositories;

import org.rodriesm.springboot.maven.item.models.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//A traves del name indicamos a que microservicio nos conectamos,
// tiene que ser igual al del applicaiton properties
//@FeignClient(name = "servicio-productos", url = "localhost:8001") si no tuviéramos Ribbon
@FeignClient(name = "servicio-productos")
public interface ProductClientRestRepository {

    //Tienen que ser los mismos endpoints
    @GetMapping("/product/list")
    List<Product> list();

    @GetMapping("/product/{id}")
    Product findById(@PathVariable Long id);
}
