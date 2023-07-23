package com.example.thimodule4.entity;



import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.*;


@Entity
public class Product implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "product_Id")
    private Integer productId;


    @Column(columnDefinition = "nvarchar(50)", name = "name")
    private String name;


    @Column(name = "price")
    private double price;


    @Column(columnDefinition = "nvarchar(50)",name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "category_Id", referencedColumnName = "category_Id")
    private Category category;


    public Product() {
    }

    public Product(Integer productId, String name, double price, String status, Category category) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.status = status;
        this.category = category;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

        Product product = (Product) target;
        name = product.getName();
        price=product.getPrice();


        ValidationUtils.rejectIfEmpty(errors, "name", "name.empty", "Name not empty.");
        if (name.length()<5 ||name.length()>50){
            errors.rejectValue("name",  "name.empty", null, "Name must be 5 -50 character");
        }

        if (price < 100000){
            errors.rejectValue("price",  "", null, "Must be greater than 100000!");
        }
    }
}
