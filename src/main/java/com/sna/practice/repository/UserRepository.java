package com.sna.practice.repository;

import com.sna.practice.model.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserRepository {

    @Select("SELECT * FROM app_users WHERE id = #{id}")
    @Results(id = "userResultMap", value = {
            @Result(property = "id",       column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email",    column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "fullName", column = "full_name"),
            @Result(property = "address",  column = "address_id",
                    one = @One(select = "com.sna.practice.repository.AddressRepository.findById"))
    })
    User findById(Long id);

    @Select("SELECT * FROM app_users")
    @ResultMap("userResultMap")
    List<User> findAll();

    @Select("""
            INSERT INTO app_users (username, email, password, full_name, address_id)
            VALUES (#{username}, #{email}, #{password}, #{fullName}, #{address.id}) returning *;
            """)
    @ResultMap("userResultMap")
    User insert(User user);

    @Select("""
            UPDATE app_users
            SET username   = #{username},
                email      = #{email},
                password   = #{password},
                full_name  = #{fullName},
                address_id = #{address.id}
            WHERE id = #{id} returning *;
            """)
    User update(User user);
    @ResultMap("userResultMap")
    @Delete("DELETE FROM app_users WHERE id = #{id}")
    void deleteById(Long id);
    @ResultMap("userResultMap")
    @Select("SELECT * FROM app_users WHERE username = #{username}")
    User findByUsername(String username);
}