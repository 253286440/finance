package org.free.sso

import java.util.Date

import org.free.sso.entity.{Role, User, UserRole}
import org.free.sso.service.{RoleService, UserService}
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired

/**
 * @author maheng
 */
class UserTest extends SpringTest{
  @Autowired
  var userService:UserService = _
  @Autowired
  var roleService:RoleService = _
  @Test
  def testInsert():Unit = {
    val record = new User;
    record.userName = "maheng"
    record.password = "111111"
    record.create_time = new Date()
    record.status = User.enableStatus
    userService.insertSelective(record)
  }

  @Test
  def testCreateRole(): Unit={
    val role = Role("ADMIN")
    val id = roleService.insertSelective(role)
    println(id)
  }

  @Test
  def testAuthorization(): Unit ={
    val effect = roleService.allowUsers(1,List("root","maheng"))
    println(effect)
  }
}
