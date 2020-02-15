package steelhacks.covid19.covid19.Entity;


import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.*;


@Document(collection="user")
public class User {

    @Id
    @Field("id")
    private Integer id;

    @Field("email")
    private String email;

    @Field("password")
    private String password;

    @Field("longitude")
    private double longitude;

    @Field("latitude")
    private Double latitude;

    @Field("age")
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
