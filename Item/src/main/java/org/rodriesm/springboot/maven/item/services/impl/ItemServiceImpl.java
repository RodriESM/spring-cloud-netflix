package org.rodriesm.springboot.maven.item.services.impl;

import org.rodriesm.springboot.maven.item.models.Item;
import org.rodriesm.springboot.maven.item.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.rodriesm.springboot.maven.item.services.ItemService;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("restTemplateItemService")
public class ItemServiceImpl implements ItemService {

    @Autowired //Hay que tener cuidado con el nombre, tiene que ser igual al del bean
    private RestTemplate productRest;

    @Override
    public List<Item> findAll() {

        //Primero ponemos la url y luego el tipo que nos devuelve
        //Tener cuidado con el http://
        List<Product> productList = Arrays.asList(productRest.getForObject("http://servicio-productos/product/list", Product[].class));

        return productList.parallelStream()
                //Construimos el item a traves de cada producto
                .map(product -> new Item(product,1))
                .collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer quantity) {
        //Necesitamos la clave-valor
        Map<String,String> pathVariables = new HashMap<>();
        pathVariables.put("id",id.toString());

        //El tercer argumento son los parámetros de la URI
        Product product = productRest.getForObject("http://servicio-productos/product/{id}", Product.class,pathVariables);

        return new Item(product,quantity);
    }
}
