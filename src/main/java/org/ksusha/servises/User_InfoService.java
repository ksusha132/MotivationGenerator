package org.ksusha.servises;


import org.ksusha.entities.User_Info;

import java.util.List;

public interface User_InfoService {
    List<User_Info> findByName(String name);

    List<User_Info> findByNameLike(String name);

    List<User_Info> findBySecName(String name);

    List<User_Info> findBySecNameLike(String secName);

    List<User_Info> findByAge(Integer age);

    List<User_Info> findByAgeWithParameters(Integer age1,Integer age2);

    List<User_Info> getAll();

    void createUser(User_Info user);

    void updateUser(User_Info user);

    void deleteUser(Long id);


}
