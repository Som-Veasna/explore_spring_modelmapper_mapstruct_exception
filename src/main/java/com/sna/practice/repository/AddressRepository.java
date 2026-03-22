package com.sna.practice.repository;

import com.sna.practice.model.entity.Address;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AddressRepository {

    @Select("SELECT * FROM addresses WHERE id = #{id}")
    Address findById(Long id);
}