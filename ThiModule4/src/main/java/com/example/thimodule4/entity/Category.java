package com.example.thimodule4.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "category_Id")
    private Integer categoryId;

    @Column(columnDefinition = "nvarchar(50)",name = "category_Name")
    public String categoryName;

    @OneToMany(mappedBy = "category")
    List<Product> products;

    public Category() {
    }

    public Category(Integer categoryId, String categoryName, List<Product> products) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.products = products;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
