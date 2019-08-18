package org.free.sso.service

import java.util.Date

import org.free.sso.entity.User
import org.free.sso.framework.mybatis.BaseService
import org.springframework.security.core.userdetails.{ReactiveUserDetailsService, UserDetails}
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

/**
 * @author maheng
 */
@Service
class UserService extends BaseService[User] with ReactiveUserDetailsService{

   def createUser(user: UserDetails): Unit = {
    val record = new User;
    record.userName = user.getUsername
    record.password = user.getPassword
    record.create_time = new Date
    record.status = User.enableStatus
    insertSelective(record)
  }

   def updateUser(user: UserDetails): Unit = {
    var record = new User
    record.userName = user.getUsername
    record.password = user.getPassword
    record.status = User.enableStatus
    updateByPrimaryKeySelective(record)
  }

   def deleteUser(username: String): Unit = {
    deleteByPrimaryKey(username)
  }


  private def status(enable:Boolean) : Int = {
    enable match {
      case true => User.enableStatus
      case _ => User.disableStatus
    }
  }

  override def findByUsername(username: String): Mono[UserDetails] = {
    logger.info("find user username : {}",username)
    val user = selectByPrimaryKey(username);
    user match {
      case u:User => {
        var _u = org.springframework.security.core.userdetails.User.withDefaultPasswordEncoder()
          .username(u.userName)
          .password(u.password)
          .roles("ADMIN")
          .build()
        Mono.just(_u)
      }
      case _ => Mono.empty()
    }
  }
}
