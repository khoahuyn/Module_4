package test.model;

import javax.persistence.*;

@Entity
public class Music {
    @Id
    @GeneratedValue
    private int id;

    @Column(columnDefinition = "nvarchar(100)")
    private String name;

    @Column(columnDefinition = "nvarchar(100)")
    private String singer;

    @Column(columnDefinition = "nvarchar(100)")
    private String kind;

    @Column(columnDefinition = "nvarchar(100)")
    private String link;


    public Music() {
    }

    public Music(int id, String name, String singer, String kind, String link) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.kind = kind;
        this.link = link;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
