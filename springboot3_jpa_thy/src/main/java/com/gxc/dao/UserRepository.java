package com.gxc.dao;

import com.gxc.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author 宫新程
 * @date 2018/9/7 10:49
 */
public interface UserRepository extends JpaRepository<User, Long> {

  List<User> findUsersByUserNameNotNull();

}
