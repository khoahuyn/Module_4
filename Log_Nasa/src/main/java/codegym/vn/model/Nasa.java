package codegym.vn.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
public class Nasa {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "nvarchar(100)")
    private String author;

    @Column(columnDefinition = "nvarchar(100)")
    private String feedback;

    @Column(columnDefinition = "nvarchar(100)")
    private String rating;


    @Column(columnDefinition = "nvarchar(100)")
    private String date;


    private int likes=0;



    public Nasa() {
    }


    public Nasa(Integer id, String author, String feedback, String rating, String date, int likes) {
        this.id = id;
        this.author = author;
        this.feedback = feedback;
        this.rating = rating;
        this.date = date;
        this.likes = likes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getDate() {
        return date;
    }

    public void setDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate today = LocalDate.now();
        this.date = today.format(formatter);
    }
}
