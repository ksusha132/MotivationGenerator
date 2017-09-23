package hello.servises;


import hello.dao.UserRepository;
import hello.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    //??

    @Override
    public List<User> findByName(String name) {
        List<User> list = userRepository.findByName(name);
        list.sort(User::compareByNameThenSecName);
        return list;
    }

    @Override
    public List<User> getAll() {
        List<User> list = userRepository.findAll();
        list.sort(Comparator.comparing(User::getName));

        // I would be happy if we could make a multiple comparator with multiple options
        return list;
    }

    @Override
    public User getById(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void updateUser(User user) {

        // there is no update function
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.delete(id);
    }

    @Override
    public List<User> findBySecName(String secName) {
        List<User> list = userRepository.findBySecName(secName);
        list.sort(User::compareBySecNameThenName);
        return list;
    }

    @Override
    public List<User> findByAge(Integer age) {
        List<User> list = userRepository.findByAge(age);
        list.sort(User::compareByAgeThenName);
        return list;
    }
}
