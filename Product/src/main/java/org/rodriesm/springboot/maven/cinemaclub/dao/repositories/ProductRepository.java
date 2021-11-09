package org.rodriesm.springboot.maven.cinemaclub.dao.repositories;

import org.rodriesm.springboot.maven.cinemaclub.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
