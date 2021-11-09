package org.rodriesm.springboot.maven.item.services;

import org.rodriesm.springboot.maven.item.models.Item;

import java.util.List;

public interface ItemService {

    List<Item> findAll();
    Item findById(Long id, Integer quantity);
}
