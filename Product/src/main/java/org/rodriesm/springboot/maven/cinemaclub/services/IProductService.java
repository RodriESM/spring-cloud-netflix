package org.rodriesm.springboot.maven.cinemaclub.services;

import org.rodriesm.springboot.maven.cinemaclub.models.Product;

import java.util.List;

public interface IProductService {

     List<Product> findAll();
     Product findById(Long id);
}
