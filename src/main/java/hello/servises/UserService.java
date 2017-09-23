package hello.servises;


import hello.entities.User;

import java.util.List;

public interface UserService {
    List<User> findByName(String name);

    List<User> findBySecName(String name);

    List<User> findByAge(Integer age);

    List<User> getAll();

    User getById(Long id);

    void createUser(User user);

    void updateUser(User user);

    void deleteUser(Long id);


}
