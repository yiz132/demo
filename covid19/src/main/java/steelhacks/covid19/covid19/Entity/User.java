package steelhacks.covid19.covid19.Entity;


import javax.persistence.*;


@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(columnDefinition="BIGINT(20)")
    private Integer id;

    @Column(columnDefinition="VARCHAR(32) NOT NULL")
    private String email;

    @Column(columnDefinition="VARCHAR(64) NOT NULL")
    private String password;

    @Column(columnDefinition="DOUBLE NOT NULL")
    private double longitude;

    @Column(columnDefinition="DOUBLE NOT NULL")
    private Double latitude;

    @Column(columnDefinition="INT NOT NULL'")
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
