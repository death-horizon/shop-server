package com.death.horizon.shopserver.dao;

import com.death.horizon.shopserver.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author dayday
 */
@Repository
@Mapper
public interface LoginDao {
    /**
     * 根据用户名和hash密码获取用户
     *
     * @param user 用户信息
     * @return 完整的用户信息
     */
    User getUser(User user);

    /**
     * 判断用户名是否已经存在
     *
     * @param username 需要判断的用户名
     * @return 存在返回true
     */
    @Select("select count(*) from user where username = #{username}")
    boolean hasUsername(@Param("username") String username);

    /**
     * 插入用户
     *
     * @param user 用户信息
     * @return 失败返回0
     */
    int insertUser(User user);

}
