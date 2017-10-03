package org.ksusha.dao;

import org.ksusha.entities.User_Info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;

import java.util.List;

public interface User_InfoRepository extends JpaRepository<User_Info, Long> {

    @Query("select u from User_Info u where u.name = :name")
    List<User_Info> findByName(@Param("name") String name);

    @Query("Select u from User_Info u where u.name like %:name%")
    List<User_Info> findByNameLike(@Param("name") String name);

    @Query("select u from User_Info u where u.age = :age")
    List<User_Info> findByAge(@Param("age") Integer age);

    @Query("select u from User_Info u where u.secName = :secName")
    List<User_Info> findBySecName(@Param("secName") String secName);

    @Query("Select u from User_Info u where u.secName like %:secName%")
    List<User_Info> findBySecNameLike(@Param("secName") String secName);

    @Query("Select u from User_Info u where u.age > :age1 and u.age < :age2")
    List<User_Info> findByAgeWithParameters(@Param("age1") Integer age1,
                                      @Param("age2") Integer age2);
}
