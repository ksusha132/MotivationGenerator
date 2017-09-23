package hello.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hello.entities.User;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where u.name = :name")
    List<User> findByName(@Param("name") String name);

    // find by login

    @Query("select u from User u where u.age = :age")
    List<User> findByAge(@Param("age") Integer age);

    // find by age (between 2 parameters)

    // fund by login (like)

    // find by name like

    @Query("select u from User u where u.secName = :secName")
    List<User> findBySecName(@Param("secName") String secName);

    // find by sec name like

    // with with role
}
