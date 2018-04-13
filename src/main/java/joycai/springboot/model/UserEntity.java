package joycai.springboot.model;

import javax.persistence.*;

@Entity
@Table(name = "userAccount")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    Long id;

    String userName;

    String pwd;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
