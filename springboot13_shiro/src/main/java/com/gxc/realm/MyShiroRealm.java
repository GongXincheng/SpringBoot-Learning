package com.gxc.realm;

import com.gxc.dao.UserInfoRepository;
import com.gxc.entity.SysPermission;
import com.gxc.entity.SysRole;
import com.gxc.entity.UserInfo;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;

/**
 * Realm 实现.
 *
 * @author 宫新程
 * @since 2018/10/16 14:19
 */
public class MyShiroRealm extends AuthorizingRealm {

  @Resource private UserInfoRepository userInfoRepository;

  /**
   * 认证.
   *
   * @param token
   * @return
   * @throws AuthenticationException
   */
  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
      throws AuthenticationException {
    System.out.println("______ MyShiroRealm.doGetAuthenticationInfo()");

    // 获取用户的输入的账号.
    String username = (String) token.getPrincipal();
    System.out.println(token.getCredentials());

    // 通过username从数据库中查找 User对象，如果找到，没找到.
    UserInfo userInfo = userInfoRepository.findByUsername(username);
    System.out.println("----->> userInfo = " + userInfo);
    if (userInfo == null) {
      return null;
    }

    return new SimpleAuthenticationInfo(
        userInfo, // 用户名
        userInfo.getPassword(), // 密码
        ByteSource.Util.bytes(userInfo.getCredentialsSalt()), // 密码盐salt = username + salt
        getName());
  }

  /**
   * 授权.
   *
   * @param principals
   * @return
   */
  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
    // 获取用户信息
    UserInfo userInfo = (UserInfo) principals.getPrimaryPrincipal();

    SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
    // 获取用户的角色信息
    for (SysRole role : userInfo.getRoleList()) {
      authorizationInfo.addRole(role.getRole());
      // 权限信息
      for (SysPermission p : role.getPermissions()) {
        authorizationInfo.addStringPermission(p.getPermission());
      }
    }
    return authorizationInfo;
  }
}
