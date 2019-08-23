package org.free.sso.mapper

import org.free.sso.entity.{Role, UserRole}
import org.free.sso.framework.mybatis.BaseMapper

/**
 * @see Role
 */
trait RoleMapper extends BaseMapper[Role]{

}
trait UserRoleMapper extends BaseMapper[UserRole]{

}
