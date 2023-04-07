package com.ipa.openapi.service;

import com.ipa.openapi.model.UserDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final String NAMESPACE = "mapper.UserMapper";
    private SqlSession session;

    @Autowired
    public UserService(SqlSession session){
        this.session = session;
    }

    public void insert(UserDTO userDTO) {
        session.insert(NAMESPACE + ".register", userDTO);
    }
    public UserDTO auth(UserDTO attempt) {
        return session.selectOne(NAMESPACE + ".auth", attempt);
    }
}
