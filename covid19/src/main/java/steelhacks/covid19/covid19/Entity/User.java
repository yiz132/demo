package steelhacks.covid19.covid19.Entity;


import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Table(name="Users")
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    private String email;

    private String password;

    private double longitude;

    private Double latitude;

    private Integer age;

    private Double temperature;

    private Integer status; //0--normal, 1--patient, 2--doctor


    public User(){
        this.status = 0;
    }
    public User(Integer id, String email, String password, double longitude, double latitude, Integer age, Double temperature, Integer status) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.longitude = longitude;
        this.latitude = latitude;
        this.age = age;
        this.temperature = temperature;
        this.status = status;
    }



    public Integer getUserId() {
        return id;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {return email;}
    public void setEmail(String email){
        this.email = email;
    }
    public Integer getAge() {return age;}

    public Double getLongitude() { return longitude;}
    public Double getLatitude() { return latitude;}
    public Double getTemperature() {return temperature;}
    public Integer getStatus() {return status;}
}
