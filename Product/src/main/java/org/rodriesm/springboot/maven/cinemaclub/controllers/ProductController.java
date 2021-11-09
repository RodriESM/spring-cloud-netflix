package org.rodriesm.springboot.maven.cinemaclub.controllers;

import org.rodriesm.springboot.maven.cinemaclub.models.Product;
import org.rodriesm.springboot.maven.cinemaclub.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

//Devuelve a JSON lo que envían los controladores
//Tipo Rest
@RestController
@RequestMapping("/product")
public class ProductController {

    //Obtenemos las variables del applicaiton properties
    @Autowired
    private Environment environment;

    @Value("${server.port}")
    private Integer port;

    @Autowired
    private IProductService productService;

    @GetMapping("/list")
    public List<Product> findAll(){
        return productService.findAll().parallelStream()
                .map(product -> {
                    product.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
                    return product;
                })
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable(name = "id") Long id) {
        Product product = productService.findById(id);
        product.setPort(port);

        /*//Simulamos el error
        boolean ok = Boolean.FALSE;
        if (ok == false){
            throw new Exception("No se pudo cargar el producto");
        }*/

        //Simulando TimeOut
        /*try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return product;
    }
}
