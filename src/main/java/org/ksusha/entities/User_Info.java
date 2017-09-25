package org.ksusha.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "user_info")
public class User_Info implements Serializable {

    public User_Info() {

    }

    public User_Info(String name, String secName, Integer age, String photo) {
        this.name = name;
        this.secName = secName;
        this.age = age;
        this.photo = photo;
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


    @Override
    public String toString() {
        return "User_Info{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", secName='" + secName + '\'' +
                ", age=" + age +
                ", photo='" + photo + '\'' +
                '}';
    }

    public static int compareByNameThenSecName(User_Info lhs, User_Info rhs) {
        if (lhs.name.equals(rhs.name)) {
            return lhs.secName.compareTo(rhs.secName);
        } else {
            return lhs.name.compareTo(rhs.name);
        }
    }

    public static int compareByAgeThenName(User_Info lhs, User_Info rhs) {
        if (lhs.age == rhs.age) {
            return lhs.name.compareTo(rhs.name);
        } else {
            return lhs.age - rhs.age;
        }
    }

    public static int compareBySecNameThenName(User_Info lhs, User_Info rhs) {
        if (lhs.secName.equals(rhs.secName)) {
            return lhs.name.compareTo(rhs.name);
        } else {
            return lhs.secName.compareTo(rhs.secName);
        }
    }
}

