package steelhacks.covid19.covid19.Entity;


import javax.persistence.*;

import javax.persistence.Entity;
@Entity
@Table(name = "Doctors")
public class Doctor {
    @Id
    @GeneratedValue
    private Integer id;

    private String email;

    private String name;

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
}
