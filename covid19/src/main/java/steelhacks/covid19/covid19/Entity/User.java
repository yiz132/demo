package steelhacks.covid19.covid19.Entity;


import javax.persistence.*;


@Entity
@Table(name = "customers")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(columnDefinition="BIGINT(20)")
    private Integer id;

    @Column(columnDefinition="VARCHAR(32) NOT NULL")
    private String username;

    @Column(columnDefinition="VARCHAR(255) DEFAULT NULL")
    private String cname;

    @Column(columnDefinition="VARCHAR(255) DEFAULT NULL")
    private String ckind;

    @Column(columnDefinition="INT(11) DEFAULT NULL'")
    private Integer aid;  //address id

    @Column(columnDefinition="VARCHAR(64) NOT NULL")
    private String password;

    /**
     * 订单
     */
   // @OneToMany(mappedBy = "user")
  //  private List<Order> orders;


    public User(){}
    public User(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Integer getCid() {
        return id;
    }

    public void setCid(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCkind() {
        return ckind;
    }

    public void setCkind(String ckind) {
        this.ckind = ckind;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
