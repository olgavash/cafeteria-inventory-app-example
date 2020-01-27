package com.cafeteriainventoryappexample.models;



import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private int productId;

    @NotNull
    @Size(min=1, message = "Name must not be empty")
    private String name;

    @NotNull
    private String vendor;

    @NotNull
    private String vendorProductNum;

    @NotNull
    private String purchaseUnitMeasure;

    @NotNull
    private float costPerPurchaseUofM;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_class_id")
    private ProductClass productClass;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,  mappedBy = "countId")
    private List<CountSheet> countSheets;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getVendorProductNum() {
        return vendorProductNum;
    }

    public void setVendorProductNum(String vendorProductNum) {
        this.vendorProductNum = vendorProductNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPurchaseUnitMeasure() {
        return purchaseUnitMeasure;
    }

    public void setPurchaseUnitMeasure(String purchaseUnitMeasure) {
        this.purchaseUnitMeasure = purchaseUnitMeasure;
    }

    public float getCostPerPurchaseUofM() {
        return costPerPurchaseUofM;
    }

    public void setCostPerPurchaseUofM(float costPerPurchaseUofM) {
        this.costPerPurchaseUofM = costPerPurchaseUofM;
    }

    public ProductClass getProductClass() {
        return productClass;
    }

    public void setProductClass(ProductClass productClass) {
        this.productClass = productClass;
    }

    public List<CountSheet> getCountSheets() {
        return countSheets;
    }

    public void setCountSheets(List<CountSheet> countSheets) {
        this.countSheets = countSheets;
    }
}
