package org.free.sso.entity

import java.util.Date

import javax.persistence.{Id, Table}

import scala.beans.BeanProperty

/**
 * table of users
 */
@Table(name = "t_user")
case class User(){
  @Id
  var userName:String = _
  var password:String = _
  var create_time:Date = _
  var status:Int = _


}
object User {
  /**
   * enable status of user
   */
  def enableStatus : Int = 1

  /**
   * disable status of user
   * @return
   */
  def disableStatus : Int = 0
}

/**
 * table of roles
 */
@Table(name = "t_role")
case class Role(@Id roleName:String){
  @Id
  @BeanProperty
  var id:Option[Int] = _


}

/**
 * relation of user and role
 * @param userName  user primary key
 * @param roleId  role primary key
 */
@Table(name = "t_user_role")
case class UserRole(@Id userName:String,@Id roleId:Int)
