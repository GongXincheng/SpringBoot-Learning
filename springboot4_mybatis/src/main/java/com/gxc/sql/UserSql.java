package com.gxc.sql;

import com.gxc.entity.UserEntity;
import com.gxc.param.UserParam;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 宫新程
 * @date 2018/9/7 14:44
 */
public class UserSql {

  private final Logger logger = LoggerFactory.getLogger(UserSql.class);

  /**
   * 使用sql类查询全部sql.
   *
   * @param user UserParam
   * @return SQL语句
   */
  public String getAllUserByClass(UserParam user) {
    logger.error(user.toString());
    StringBuilder sql = new StringBuilder("select * from users where 1=1 ");
    if (user != null) {
      if (StringUtils.isNotBlank(user.getUserName())) {
        sql.append(" and userName like #{userName}");
      }
      if (StringUtils.isNotBlank(user.getUserSex())) {
        System.out.println("_________________");
        sql.append(" and user_sex = #{userSex}");
      }
    }
    sql.append(" order by id desc");
    sql.append(" limit " + user.getBeginLine() + "," + user.getPageSize());
    logger.error(sql.toString());
    return sql.toString();
  }

  /**
   * 简洁方式
   *
   * @param user UserParam
   * @return sql语句
   */
  public String getAllUserByClass2(UserParam user) {
    String sql = new SQL() {
      {
        SELECT("*");
        FROM("users");
        if (StringUtils.isNotBlank(user.getUserName())) {
          WHERE("userName like #{userName}");
        }
        if (StringUtils.isNotBlank(user.getUserSex())) {
          WHERE("user_sex = #{userSex}");
        }
        ORDER_BY("id desc");

      }
    }.toString();

    //添加分页
    StringBuilder sb = new StringBuilder(sql);
    //sb.append(" order by id desc");
    sb.append(" limit " + user.getBeginLine() + "," + user.getPageSize());

    logger.error(sb.toString());
    return sb.toString();
  }
}
