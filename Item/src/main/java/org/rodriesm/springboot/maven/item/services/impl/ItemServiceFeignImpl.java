package org.rodriesm.springboot.maven.item.services.impl;

import org.rodriesm.springboot.maven.item.models.Item;
import org.rodriesm.springboot.maven.item.repositories.ProductClientRestRepository;
import org.rodriesm.springboot.maven.item.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("itemServiceFeign") //Si no ponemos nombre, por defecto coge el de la clase pero empezando en minus
@Primary //De esta forma indicamos que este componente es el que se inyecta (Por el tema del ItemService)
public class ItemServiceFeignImpl implements ItemService {

    //Se inyecta solo al tener la anotación Feign
    @Autowired
    private ProductClientRestRepository productClientRepository;

    @Override
    public List<Item> findAll() {
        return productClientRepository.list().parallelStream().map(product -> new Item(product,1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer quantity) {
        return new Item(productClientRepository.findById(id),quantity);
    }
}
