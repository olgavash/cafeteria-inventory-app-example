package com.cafeteriainventoryappexample.models.data;

import com.cafeteriainventoryappexample.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ProductDao extends CrudRepository<Product, Integer> {


}
