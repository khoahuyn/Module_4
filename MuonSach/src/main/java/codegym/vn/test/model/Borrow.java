package codegym.vn.test.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


@Entity
public class Borrow {
    @Id
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_name", columnDefinition = "nvarchar(50)")
    private String userName;


    @Column(name = "borrowed_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date borrowedDate;

    @Column(name = "pay_day")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date payDay;


    @Column(name = "status")
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "book_id")
    private Book book;

    public Borrow() {
    }

    public Borrow(Integer userId, String userName, Date borrowedDate, Date payDay, boolean status, Book book) {
        this.userId = userId;
        this.userName = userName;
        this.borrowedDate = borrowedDate;
        this.payDay = payDay;
        this.status = status;
        this.book = book;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(Date borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public Date getPayDay() {
        return payDay;
    }

    public void setPayDay(Date payDay) {
        this.payDay = payDay;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
