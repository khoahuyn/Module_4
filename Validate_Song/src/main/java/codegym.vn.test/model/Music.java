package codegym.vn.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Music {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(columnDefinition = "nvarchar(100)")
    @NotBlank( message = "Tên bài hát k dc để trống")
    @Size(max = 800)
    @Pattern(regexp =  "^[a-zA-Z0-9]+$")
    private String name;

    @Column(columnDefinition = "nvarchar(100)")
    @NotBlank( message = "Tên nghệ sĩ k dc để trống")
    @Size(max = 300)
    @Pattern(regexp =  "^[a-zA-Z0-9]+$")
    private String singer;

    @Column(columnDefinition = "nvarchar(100)")
    @NotBlank( message = "Thể loại k dc để trống")
    @Size(max = 1000)
    @Pattern(regexp =  "^[a-zA-Z0-9,]+$")
    private String kind;

    @Column(columnDefinition = "nvarchar(100)")
    private String link;


    public Music() {
    }

    public Music(Integer id, String name, String singer, String kind, String link) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.kind = kind;
        this.link = link;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
