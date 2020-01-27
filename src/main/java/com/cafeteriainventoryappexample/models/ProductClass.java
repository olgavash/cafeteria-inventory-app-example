package com.cafeteriainventoryappexample.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ProductClass")
public class ProductClass  {

    @Id
    @GeneratedValue
    private int productClassId;
    private String description;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "productClass")
    private List<Product> products;

    public ProductClass() {}

    public ProductClass(String description) {
        this.description = description;
    }

    public int getProductClassId() {
        return productClassId;
    }

    public void setProductClassId(int productClassId) {
        this.productClassId = productClassId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}

