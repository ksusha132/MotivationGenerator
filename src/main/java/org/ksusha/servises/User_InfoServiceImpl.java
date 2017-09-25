package org.ksusha.servises;


import org.ksusha.dao.User_InfoRepository;
import org.ksusha.entities.User_Info;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Service
public class User_InfoServiceImpl implements User_InfoService {

    private static final Logger log = LoggerFactory.getLogger(User_InfoServiceImpl.class);

    @Autowired
    private User_InfoRepository user_infoRepository;

    @Override
    public List<User_Info> findByName(String name) {
        List<User_Info> list = user_infoRepository.findByName(name);
        list.sort(User_Info::compareByNameThenSecName);
        return list;
    }

    @Override
    public List<User_Info> getAll() {
        List<User_Info> list = user_infoRepository.findAll();
        log.debug(Arrays.deepToString(list.toArray()));
        list.sort(Comparator.comparing(User_Info::getName));

        // I would be happy if we could make a multiple comparator with multiple options
        return list;
    }

    @Override
    public void createUser(User_Info user) {
        user_infoRepository.save(user);
    }

    @Override
    public void updateUser(User_Info user) {

        user_infoRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        user_infoRepository.delete(id);
    }

    @Override
    public List<User_Info> findBySecName(String secName) {
        List<User_Info> list = user_infoRepository.findBySecName(secName);
        list.sort(User_Info::compareBySecNameThenName);
        return list;
    }

    @Override
    public List<User_Info> findByAge(Integer age) {
        List<User_Info> list = user_infoRepository.findByAge(age);
        list.sort(User_Info::compareByAgeThenName);
        return list;
    }

    @Override
    public List<User_Info> findByAgeWithParameters(Integer age1, Integer age2) {
        return user_infoRepository.findByAgeWithParameters(age1, age2);
    }

    @Override
    public List<User_Info> findByNameLike(String name) {
        return user_infoRepository.findByNameLike(name);
    }

    @Override
    public List<User_Info> findBySecNameLike(String secName) {
        return user_infoRepository.findBySecNameLike(secName);
    }
}
