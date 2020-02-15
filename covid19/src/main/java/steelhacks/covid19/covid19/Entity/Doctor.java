package steelhacks.covid19.covid19.Entity;


import org.springframework.stereotype.Component;

import javax.persistence.*;

import javax.persistence.Entity;
@Component
@Entity
@Table(name = "Doctors")
public class Doctor {
    @Id
    @GeneratedValue
    private Integer id;

    private String email;

    private String name;

    private String password;

    private double longitude;

    private double latitude;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {this.email = email;}

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

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
