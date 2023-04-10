package com.ipa.openapi.service;

import com.ipa.openapi.dao.UserDao;
import com.ipa.openapi.model.UserDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private UserDao userDao;

    public UserService(PasswordEncoder passwordEncoder, @Qualifier("userDao") UserDao userDao) {
        this.passwordEncoder = passwordEncoder;
        this.userDao = userDao;
    }

    public void register(UserDTO userDTO) {
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        userDao.register(userDTO);
    }

    public UserDTO findByUsername(String username) {
        System.out.println("UserService.findByUsername >> " + username);
        return userDao.findByUsername(username);
    }

}
