package org.free.sso.service

import java.util.Date

import org.free.sso.entity.User
import org.free.sso.framework.auth.AccessUser
import org.free.sso.framework.mybatis.BaseService
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.{ReactiveUserDetailsService, UserDetails}
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

/**
 * jdbcUserDetailService that do authorizations
 * @author maheng
 */
@Service
class UserService extends BaseService[User] with ReactiveUserDetailsService{

  /**
   * create user
   * @param user user information
   */
   def createUser(user: UserDetails): Unit = {
    val record = new User;
    record.userName = user.getUsername
    record.password = user.getPassword
    record.create_time = new Date
    record.status = User.enableStatus
    insertSelective(record)
  }

  /**
   * login method
   * @param username  username
   * @return  granted authority
   */
  override def findByUsername(username: String): Mono[UserDetails] = {
    logger.info("find user username : {}",username)
    val user = selectByPrimaryKey(username);
    val access = new AccessUser(user.userName,user.password,List(new SimpleGrantedAuthority("ADMIN")))
    Mono.just(access)
  }
}
