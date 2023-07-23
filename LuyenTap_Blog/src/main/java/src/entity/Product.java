package src.entity;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Product implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "product_Id")
    private Integer productId;

    @Column(columnDefinition = "nvarchar(50)", name = "author")
    private String author;

    @Column(columnDefinition = "nvarchar(50)", name = "name")
    private String name;

    @Column(columnDefinition = "nvarchar(100)", name = "description")
    private String description;

    @Column(name = "date_Release")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateRelease;

    @Column(columnDefinition = "nvarchar(100)", name = "content")
    private String content;

    @ManyToOne
    @JoinColumn(name = "category_Id", referencedColumnName = "category_Id")
    private Category category;

    public Product() {
    }

    public Product(Integer productId, String author, String name, String description, Date dateRelease, String content, Category category) {
        this.productId = productId;
        this.author = author;
        this.name = name;
        this.description = description;
        this.dateRelease = dateRelease;
        this.content = content;
        this.category = category;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateRelease() {
        return dateRelease;
    }

    public void setDateRelease(Date dateRelease) {
        this.dateRelease = dateRelease;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
        author = product.getAuthor();
        name = product.getName();
        description = product.getDescription();
        content = product.getContent();

        ValidationUtils.rejectIfEmpty(errors, "author", "author.empty", "Author not empty.");
        ValidationUtils.rejectIfEmpty(errors, "name", "name.empty", "Name not empty.");
        ValidationUtils.rejectIfEmpty(errors, "description", "description.empty", "Description not empty.");
        ValidationUtils.rejectIfEmpty(errors, "content", "content.empty", "Content not empty.");


//
//        ValidationUtils.rejectIfEmpty(errors, "productName", "productName.empty", null, "Not empty");
//        if (productName.length() > 50){
//            errors.rejectValue("productName",  "productName.empty", null, "Too long!");
//        }
//
//        ValidationUtils.rejectIfEmpty(errors, "quantity",  "", null, "Not empty");
//        if (quantity < 0){
//            errors.rejectValue("quantity",  "", null, "Must be greater than 0!");
//        }
//
//        ValidationUtils.rejectIfEmpty(errors, "price",  "", null, "Not empty");
//        if (price < 0){
//            errors.rejectValue("price",  "", null, "Must be greater than 0!");
//        }
    }
}
