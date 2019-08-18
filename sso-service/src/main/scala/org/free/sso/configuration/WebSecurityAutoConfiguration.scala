package org.free.sso.configuration

import org.free.sso.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.{Bean, Configuration}
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.web.server.SecurityWebFilterChain

/**
 * @author maheng
 */
@Configuration
@EnableWebFluxSecurity
class WebSecurityAutoConfiguration {

  @Autowired
  var userService:UserService = _;

  @Bean
  def securityWebFilterChain(http: ServerHttpSecurity) :SecurityWebFilterChain = {
    http
      .authorizeExchange()
      .pathMatchers("/auth/**").permitAll()
      .anyExchange().authenticated()
      .and().formLogin().and()
      .build()
  }
}
