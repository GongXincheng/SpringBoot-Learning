package com.gxc.repository;

import com.gxc.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 宫新程
 * @date 2018/9/9 23:22
 */
public interface UserRepository extends JpaRepository<User,Long> {

}
