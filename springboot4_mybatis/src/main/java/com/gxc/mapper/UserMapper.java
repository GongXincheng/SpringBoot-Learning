package com.gxc.mapper;

import com.gxc.entity.UserEntity;
import com.gxc.enums.UserSexEnum;
import com.gxc.param.UserParam;
import com.gxc.sql.UserSql;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * @author 宫新程
 * @date 2018/9/7 13:22
 */
public interface UserMapper {

  List<UserEntity> getAll();

  List<UserEntity> getList(UserParam userParam);

  int getCount(UserParam userParam);

  UserEntity getOne(Long id);

  void insert(UserEntity user);

  int update(UserEntity user);

  int delete(Long id);



  /**
   * 查询全部.
   * @return  List<UserEntity>
   */
  @Select("select * from users")
  @Results({
      @Result(property = "userSex", column = "user_sex", javaType = UserSexEnum.class),
      @Result(property = "nickName", column = "nick_name")
  })
  List<UserEntity> getAllByAnno();

  /**
   * 根据id查询.
   * @param id Id
   * @return UserEntity
   */
  @Select("select * from users where id = #{id}")
  @Results({
      @Result(property = "userSex", column = "user_sex", javaType = UserSexEnum.class),
      @Result(property = "nickName", column = "nick_name")
  })
  UserEntity getUserByIdAndAnno(Long id);


  // sqlClass方式一：
  @SelectProvider(type = UserSql.class, method = "getAllUserByClass")
  @Results({
      @Result(property = "userSex", column = "user_sex", javaType = UserSexEnum.class),
      @Result(property = "nickName", column = "nick_name")
  })
  List<UserEntity> getAllUserBySqlClass(UserParam userParam);

  // sqlClass方式二：（推荐）
  @SelectProvider(type = UserSql.class, method = "getAllUserByClass2")
  @Results({
      @Result(property = "userSex", column = "user_sex", javaType = UserSexEnum.class),
      @Result(property = "nickName", column = "nick_name")
  })
  List<UserEntity> getAllUserBySqlClass2(UserParam userParam);

}
