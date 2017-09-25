package org.ksusha.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "user")
public class User implements Serializable{

    public User(){

    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    public List<String> getRoles(){
       return getUserRoles().stream().map(user_role -> user_role.getRole().getName()).collect(Collectors.toList());
    }

    //

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private User_Info user_info;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
    private Set<User_Role> userRoles;

    //

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User_Info getUser_info() {
        return user_info;
    }

    public void setUser_info(User_Info user) {
        this.user_info = user;
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
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
               // ", roles=" + getRoles() +
                '}';
    }
}
