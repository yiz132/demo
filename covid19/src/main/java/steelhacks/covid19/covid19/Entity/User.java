package steelhacks.covid19.covid19.Entity;


import javax.persistence.*;


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
