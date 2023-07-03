package codegym.vn.test.model;


import javax.persistence.*;
import java.util.List;


@Entity
public class Book {
    @Id
    @GeneratedValue
    @Column(name = "book_id")
    private Integer bookId;

    @Column(columnDefinition = "nvarchar(100)")
    private String author;

    private String description;

    private String name;

    private int quantity;



    @OneToMany(mappedBy = "book")
    private List<Borrow> borrow;


    public Book() {
    }

    public Book(Integer bookId, String author, String description, String name, int quantity, List<Borrow> borrow) {
        this.bookId = bookId;
        this.author = author;
        this.description = description;
        this.name = name;
        this.quantity = quantity;
        this.borrow = borrow;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<Borrow> getBorrow() {
        return borrow;
    }

    public void setBorrow(List<Borrow> borrow) {
        this.borrow = borrow;
    }
}
