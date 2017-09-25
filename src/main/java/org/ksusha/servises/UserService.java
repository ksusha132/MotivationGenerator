package org.ksusha.servises;


import org.ksusha.entities.User;

import java.util.List;

public interface UserService {
    User getUserByLogin(String login);

    User getUserByLoginLike(String login);

    User getUserById(Long id);
}

