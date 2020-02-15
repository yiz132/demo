package steelhacks.covid19.covid19.Entity;


import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.*;


@Entity
@Document(collection="user")
public class User {

    @Id
    @Field("BIGINT(20)")
    private Integer id;

    @Field("VARCHAR(32) NOT NULL")
    private String email;

    @Field("VARCHAR(64) NOT NULL")
    private String password;

    @Field("DOUBLE NOT NULL")
    private double longitude;

    @Field("DOUBLE NOT NULL")
    private Double latitude;

    @Field("INT NOT NULL'")
    private Integer age;


    public User(){}
    public User(Integer id, String email, String password, double longitude, double latitude, Integer age) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.longitude = longitude;
        this.latitude = latitude;
        this.age = age;
    }



    public Integer getUserId() {
        return id;
    }

    public String getPassword() {
        return password;
    }
    public String getEmail() {return email;}
    public Integer getAge() {return age;}

    public Double getLongitude() { return longitude;}
    public Double getLatitude() { return latitude;}
}
