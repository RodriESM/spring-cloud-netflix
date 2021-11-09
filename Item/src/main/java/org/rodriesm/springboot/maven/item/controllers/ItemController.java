package org.rodriesm.springboot.maven.item.controllers;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.rodriesm.springboot.maven.item.models.Item;
import org.rodriesm.springboot.maven.item.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.rodriesm.springboot.maven.item.services.ItemService;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    @Qualifier("itemServiceFeign")
    private ItemService itemService;

    @GetMapping("/list")
    public List<Item> list(){
        return itemService.findAll();
    }

    @HystrixCommand(fallbackMethod = "metodoDeFallo")
    @GetMapping("/{id}/quantity/{quantity}")
    public Item findById(@PathVariable Long id, @PathVariable Integer quantity){
        return itemService.findById(id,quantity);
    }

    public Item metodoDeFallo( Long id,Integer quantity){
        Item item = new Item();
        Product product = new Product();
        item.setQuantity(quantity);
        product.setId(id);
        product.setName("Ratón Logitech G530");
        product.setPrice(100.0);
        item.setProduct(product);

        return item;
    }
}
