package org.free.sso.entity

import java.util.Date

import javax.persistence.{Id, Table}

@Table(name = "t_user")
case class User(){
  @Id
  var userName:String = _
  var password:String = _
  var create_time:Date = _
  var status:Int = _


}
object User {
  def enableStatus : Int = 1
  def disableStatus : Int = 0
}
