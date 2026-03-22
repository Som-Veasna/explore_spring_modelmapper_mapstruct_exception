package com.sna.practice.repository;

import com.sna.practice.model.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserRepository {
     @Results(id = "UserMapper", value = {
             @Result(property = "fullName",column = "full_name")
     })
    @Select("SELECT * FROM app_users WHERE id = #{id}")
    User findById(Long id);
    @ResultMap("UserMapper")
    @Select("SELECT * FROM app_users")
    List<User> findAll();
    @ResultMap("UserMapper")
    @Select("""
            INSERT INTO app_users (username, email, password, full_name)
            VALUES (#{username}, #{email}, #{password}, #{fullName}) returning *;
            """)
    User insert(User user);
    @ResultMap("UserMapper")
    @Select("""
            UPDATE app_users
            SET username  = #{username},
                email     = #{email},
                password  = #{password},
                full_name = #{fullName}
            WHERE id = #{id} returning *;
            """)
    User update(User user);
    @ResultMap("UserMapper")
    @Delete("DELETE FROM app_users WHERE id = #{id}")
    void deleteById(Long id);
    @ResultMap("UserMapper")
    @Select("SELECT * FROM app_users WHERE username = #{username}")
    User findByUsername(String username);
}