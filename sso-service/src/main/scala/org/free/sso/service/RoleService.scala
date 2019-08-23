package org.free.sso.service

import org.free.sso.entity.{Role, UserRole}
import org.free.sso.framework.mybatis.BaseService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * @see Role
 * @author maheng
 */
@Service
class RoleService extends BaseService[Role]{
  @Autowired
  var userRoleService:UserRoleService = _

  /**
   * grant the users to the target role
   * @param roleId  target role primary key
   * @param users   target role of users to be added
   */
  def allowUsers(roleId:Int,users: List[String]):Unit = {
    val authorizations = users.map(UserRole(_,roleId))
    userRoleService.insertList(authorizations)
  }

}
@Service
class UserRoleService extends BaseService[UserRole]{

}
