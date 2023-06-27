package codegym.vn.test.model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Music implements Validator {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(columnDefinition = "nvarchar(100)")
    private String name;

    private String singer;

    private String kind;

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


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Music music=(Music) target;
        name=music.getName();
        singer=music.getSinger();
        kind=music.getKind();
        String[] specialCharacters = { "@", ";", ".", "=", "-", "+",","};


        ValidationUtils.rejectIfEmpty(errors,"name","name.empty","Name not empty.");
        if (name.length() > 800) {
            errors.rejectValue("name", "name.length","Name is not more 800 characters.");
        }
        for(int i=0;i<specialCharacters.length;i++){
            if(name.contains(specialCharacters[i])){
                errors.rejectValue("name", "name.special"," Name does not contain special characters.");
                break;
            }
        }

        ValidationUtils.rejectIfEmpty(errors,"singer","singer.empty","Singer not empty.");
        if (singer.length() > 300) {
            errors.rejectValue("singer", "singer.length","Singer is not more 300 characters.");
        }
        for(int i=0;i<specialCharacters.length;i++){
            if(singer.contains(specialCharacters[i])){
                errors.rejectValue("singer", "singer.special","Singer does not contain special characters.");
                break;
            }
        }

        ValidationUtils.rejectIfEmpty(errors,"kind","kind.empty","Kind of music not empty.");
        if ( kind.length() > 1000) {
            errors.rejectValue("kind", "kind.length","Kind is not more 1000 characters.");
        }
        for(int i=0;i<specialCharacters.length;i++){
            if(kind.contains(specialCharacters[i])){
                errors.rejectValue("kind", "kind.special","Kind of music does not contain special characters.");
                break;
            }
        }
    }
}
