package org.free.sso.controller

import org.springframework.web.bind.annotation.{GetMapping, RequestMapping, RestController}
import reactor.core.publisher.Mono

/**
 * @author maheng
 */
@RestController
@RequestMapping(Array("auth"))
class AuthController {

  @GetMapping(Array("login"))
  def login(auth:Auth) : Mono[String] = {

    Mono.just("ok")
  }

}

case class Auth(userName:String,password:String)
