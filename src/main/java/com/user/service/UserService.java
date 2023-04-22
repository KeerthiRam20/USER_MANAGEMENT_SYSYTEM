package com.user.service;

import com.user.Repository.UserRepository;
import com.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Iterable<User> list() {

        return userRepository.findAll();
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void save(List<User> users) {

        userRepository.saveAll(users);
    }
}

//    public User usersave (User user){
//        return userRepository.save(user);
//    }

//    public List<User> getallUsers() {
//        return userRepository.findAll();
//    }


//}
