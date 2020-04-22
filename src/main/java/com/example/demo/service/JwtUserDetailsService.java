package com.example.demo.service;

import com.example.demo.model.UserDao;
import com.example.demo.model.UserDto;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {


    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

       UserDao userDao = repository.findByUsername(username);
       if (userDao == null) {
           throw new UsernameNotFoundException("User not found with username: " + username);

       }

       return new User(userDao.getUsername(), userDao.getPassword(), new ArrayList<>());
    }


    public UserDao save(UserDto userDto) {
        UserDao userDao = new UserDao();
        userDao.setUsername(userDto.getUsername());
        userDao.setPassword(bcryptEncoder.encode(userDto.getPassword()));
        userDao.setEmail(userDto.getEmail());

        return repository.save(userDao);
    }
}
