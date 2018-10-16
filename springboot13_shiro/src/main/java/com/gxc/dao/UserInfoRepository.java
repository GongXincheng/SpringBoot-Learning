package com.gxc.dao;

import com.gxc.entity.UserInfo;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 宫新程
 * @since 2018/10/16 14:23
 */
public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {

  /**
   * 根据账号查询用户信息.
   * @param username
   * @return
   */
  UserInfo findByUsername(String username);

}
