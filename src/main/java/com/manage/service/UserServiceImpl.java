package com.manage.service;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.manage.exception.NotUserExists;
import com.manage.exception.UserNotFoundException;
import com.manage.model.User;
import com.manage.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUserById(int id) {
        return Optional.of(userRepository.findById(id).orElseThrow(()-> new UserNotFoundException("User not found")));
    }

    @Override
    public User updateUser(int id, User updatedUser) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException("User not found");
        }
        updatedUser.setId(id); 
        return userRepository.save(updatedUser);
    }

    @Override
    public String deleteUserById(int id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException("User not found");
        }
        userRepository.deleteById(id);
        return "User deleted succefully";
    }

    @Override
    public List<User> getAllUsers() {
    	List<User> users=userRepository.findAll();
    	if(users.isEmpty())
    	{
    		throw new NotUserExists("User not found");
    	}
        return userRepository.findAll();
    }
}