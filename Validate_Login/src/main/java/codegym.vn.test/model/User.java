package codegym.vn.test.model;

import org.aspectj.bridge.IMessage;

import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
public class User {

    @Id
    @GeneratedValue
    private Integer id;


    @NotBlank(message = "First name khong duoc de trong")
    @Size(min = 5, max = 45, message = "First name co do dai tu 5 - 45 ky tu" )
    @Column(columnDefinition = "nvarchar(45)")
    private String firstName;

    @NotBlank(message = "Last name khong duoc de trong")
    @Size(min = 5, max = 45, message = "Last name co do dai tu 5 - 45 ky tu" )
    @Column(columnDefinition = "nvarchar(45)")
    private String lastName;

    @Pattern(regexp = "^\\+(?:[0-9] ?){6,14}[0-9]$", message = "So dien thoai khong dung cu phap")
    @Column
    private String phoneNumber;


    @Min(18)
    private int age;
    @Pattern(regexp = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}",message = "Email k hợp lệ")
    @Email
    private String email;


    public User() {
    }

    public User(Integer id, String firstName, String lastName, String phoneNumber, int age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
