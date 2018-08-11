package com.kaiser.login.service;

import java.util.Arrays;
import java.util.HashSet;

import com.kaiser.login.model.Role;
import com.kaiser.login.model.User;
import com.kaiser.login.repository.RoleRepository;
import com.kaiser.login.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;



@Service("userService")
public class UserServiceImpl implements UserService {

    Logger log = LoggerFactory.getLogger("LoginController.class");

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;


    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveUser(User user){

//        log.info("############################## user.getPassword() : "+ user.getPassword());
//        log.info("############################## bCryptPasswordEncoder.encode(user.getPassword()) : "+ bCryptPasswordEncoder.encode(user.getPassword()));

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole =roleRepository.findByRole("ADMIN");


        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));



        log.info("###################### ", user.getPassword());

        userRepository.save(user);

    }


}
