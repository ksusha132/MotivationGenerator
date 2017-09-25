package org.ksusha.dao;


import org.ksusha.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from User u where u.login = :login")
    User findByLogin(@Param("login") String login);

    @Query("Select u from User u where u.login like %:login%")
    User findByLoginLike(@Param("login") String login);


}