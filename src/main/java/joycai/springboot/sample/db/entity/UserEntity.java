package joycai.springboot.sample.db.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_user_account", indexes = {
        @Index(columnList = "userName", unique = true)
})
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 1000L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 128)
    private String userName;

    private String pwd;

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
