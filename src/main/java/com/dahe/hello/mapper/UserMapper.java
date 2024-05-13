package com.dahe.hello.mapper;

import com.dahe.hello.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    /**
     * 传统的xml配置
     */
    List<User> orderBy(String field, String sort);

    List<User> orderBySafe(String field);


    @Select("select * from users where user like CONCAT('%', #{user}, '%')")
    List<User> queryByUser(@Param("user") String user);

    @Select("select * from users where id = ${id}")
    List<User> queryById1(@Param("id") String id);

    @Select("select * from users where id = ${id}")
    List<User> queryById2(@Param("id") Integer id);


    // 使用#{}会产生报错
    @Select("select * from users order by ${field} desc")
    List<User> orderBy2(@Param("field") String field);

    @Select("select * from users")
    List<User> list();

    // 模糊搜索，直接'%#{q}%' 会报错
    // 安全代码：@Select("select * from users where user like concat('%',#{q},'%')")
    @Select("select * from users where user like '%${q}%'")
    List<User> search(String q);

}
