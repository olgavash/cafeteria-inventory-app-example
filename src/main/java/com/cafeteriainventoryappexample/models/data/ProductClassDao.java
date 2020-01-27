package com.cafeteriainventoryappexample.models.data;

import com.cafeteriainventoryappexample.models.ProductClass;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ProductClassDao extends CrudRepository<ProductClass, Integer> {
    default ProductClass findOne(Integer productClassId) {
        return (ProductClass) findById(productClassId).orElse(null);
    }

}
