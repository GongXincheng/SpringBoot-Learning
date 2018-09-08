package com.gxc.dao;

import com.gxc.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author 宫新程
 * @date 2018/9/6 22:54
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
