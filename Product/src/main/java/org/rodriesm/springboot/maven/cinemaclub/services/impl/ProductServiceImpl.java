package org.rodriesm.springboot.maven.cinemaclub.services.impl;

import org.rodriesm.springboot.maven.cinemaclub.dao.repositories.ProductRepository;
import org.rodriesm.springboot.maven.cinemaclub.models.Product;
import org.rodriesm.springboot.maven.cinemaclub.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        List<Product> productList = productRepository.findAll();

        if(!productList.isEmpty()) {
            return productList;
        }

        return Collections.emptyList();
    }

    @Override
    @Transactional(readOnly = true)
    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ExpressionException("Product not found"));
    }
}
