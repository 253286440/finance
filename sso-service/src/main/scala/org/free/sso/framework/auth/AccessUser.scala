package org.free.sso.framework.auth

import java.util

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.{User, UserDetails}
import org.springframework.security.crypto.factory.PasswordEncoderFactories

import scala.beans.BeanProperty

/**
 * info of current login user
 * @author maheng
 */
class AccessUser(@BeanProperty username:String,
                  @BeanProperty password:String,
                  @BeanProperty authorities:List[GrantedAuthority]) extends UserDetails{

  override def getUsername: String = username
  override def getPassword: String = PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(password)
  override def getAuthorities: java.util.Collection[_ <: GrantedAuthority] = collection.JavaConverters.asJavaCollection(authorities)
  override def isAccountNonExpired: Boolean = true

  override def isAccountNonLocked: Boolean = true

  override def isCredentialsNonExpired: Boolean = true

  override def isEnabled: Boolean = true
}
