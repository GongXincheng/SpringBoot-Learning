package com.gxc.service;

import com.gxc.entity.Users;
import com.gxc.mapper.UsersMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.annotation.Resource;

/**
 * @author 宫新程
 * @date 2018/9/8 14:17
 */
@Service
public class UserService {

  private final Logger logger = LoggerFactory.getLogger(UserService.class);

  @Resource
  private UsersMapper usersMapper;

  @Resource
  RedisTemplate redisTemplate;

  /**
   * 获取所有User列表 注意：高并发产生问题：缓存穿透.
   *
   * @return List
   */
  public List<Users> getAllUsers() {
    ValueOperations<Object,Object> valueOperations = redisTemplate.opsForValue();

    // 查询缓存
    List<Users> userList = (List<Users>) valueOperations.get("userList");
    logger.error("当前线程为_____：{}", Thread.currentThread().getName());
    //双重检测锁
    if (userList == null || userList.size()==0) {
      synchronized (this) {
        // 再从redis中获取一次
        userList = (List<Users>) valueOperations.get("userList");
        if (userList == null || userList.size()==0) {
          logger.error("当前线程为====== ：{}", Thread.currentThread().getName());
          logger.error("查询数据库");
          // 从数据库中获取
          userList = this.usersMapper.findAllUsers();
          // 将数据保存到 Redis 中
          valueOperations.set("userList", userList);
        }
      }
    }
    return userList;
  }
}
