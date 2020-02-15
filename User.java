package steelhacks.covid19.covid19.Entity;


import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.*;


@Entity
@Document("user")
public class User {

    @Id

    @Field("id")
    private Integer id;

    @Field("username")
    private String username;

    @Field("name")
    private String name;

    @Field("kind")
    private String kind;

    @Field("age")
    private Integer age;

    @Column(columnDefinition="VARCHAR(64) NOT NULL")
    private String password;


    public User(){}
    public User(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
