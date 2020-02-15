package steelhacks.covid19.covid19.Entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.*;

import javax.persistence.Entity;

@Document(collection="doctors")
public class Doctor {
    @Id
    @Field("id")
    private Integer id;

    @Field("email")
    private String email;

    @Field("name")
    private String name;

    @Field("VARCHAR(64) NOT NULL")
    private String password;


    public Doctor(){}
    public Doctor(Integer id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setUsername(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
