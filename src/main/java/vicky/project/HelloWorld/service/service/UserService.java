package vicky.project.HelloWorld.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vicky.project.HelloWorld.models.User;
import vicky.project.HelloWorld.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user){
        return userRepository.save(user);
    }

    public  User getUserByID(Long id){
        return userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found."));
    }




}
