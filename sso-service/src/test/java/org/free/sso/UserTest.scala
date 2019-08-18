package org.free.sso

import java.util.Date

import org.free.sso.entity.User
import org.free.sso.service.UserService
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired

/**
 * @author maheng
 */
class UserTest extends SpringTest{
  @Autowired
  var userService:UserService = _

  @Test
  def testInsert():Unit = {
    val record = new User;
    record.userName = "maheng"
    record.password = "111111"
    record.create_time = new Date()
    record.status = User.enableStatus
    userService.insertSelective(record)
  }
}
