package com.ipa.openapi.dao;

import com.ipa.openapi.model.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;

@Mapper
public interface UserDao {
    void auth(String username) throws DataAccessException;

    void register(UserDTO userDTO);

    UserDTO findByUsername(String username) throws DataAccessException;
}
