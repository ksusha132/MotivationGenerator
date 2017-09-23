package hello.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class User implements Serializable {

    public User() {

    }

    public User(String name, String secName, Integer age, String photo) {
        this.name = name;
        this.secName = secName;
        this.age = age;
        this.photo = photo;
    }

    public User(String name, String secName, Integer age, String photo, Login login, Set<User_Role> userRoles) {
        this.name = name;
        this.secName = secName;
        this.age = age;
        this.photo = photo;
        this.login = login;
        this.userRoles = userRoles;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "secName")
    private String secName;

    @Column(name = "age")
    private Integer age;

    @Column(name = "photo")
    private String photo;

    //

    @OneToOne
    @JoinColumn(name = "login_id", referencedColumnName = "id")
    private Login login;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
    private Set<User_Role> userRoles;

    //

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecName() {
        return secName;
    }

    public void setSecName(String secName) {
        this.secName = secName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public Set<User_Role> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<User_Role> userRoles) {
        this.userRoles = userRoles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", secName='" + secName + '\'' +
                ", age=" + age +
                ", photo='" + photo + '\'' +
                ", login=" + login +
                ", userRoles=" + userRoles +
                '}';
    }

    public static int compareByNameThenSecName(User lhs, User rhs) {
        if (lhs.name.equals(rhs.name)) {
            return lhs.secName.compareTo(rhs.secName);
        } else {
            return lhs.name.compareTo(rhs.name);
        }
    }

    public static int compareByAgeThenName(User lhs, User rhs) {
        if (lhs.age == rhs.age) {
            return lhs.name.compareTo(rhs.name);
        } else {
            return lhs.age - rhs.age;
        }
    }

    public static int compareBySecNameThenName(User lhs, User rhs) {
        if (lhs.secName.equals(rhs.secName)) {
            return lhs.name.compareTo(rhs.name);
        } else {
            return lhs.secName.compareTo(rhs.secName);
        }
    }
}

