package com.gxc.dao;

import com.gxc.entity.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 宫新程
 * @date 2018/9/6 15:14
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long>, JpaSpecificationExecutor<User> {

 // List<User> findUserByUserNameLike(String username);

  List<User> findByIdBetween(long star, long end);

  List<User> findUserByIdIn(List<Long> ids);

  /**
   * 分页.
   * @param username 用户名称
   * @return
   */
  Page<User> findUserByUserNameLike(String username, Pageable pageable);

  /**
   * 获取前15个用户的信息
   * @param userName 用户名
   * @return
   */
  List<User> findTop15ByUserNameLike(String userName);

}
