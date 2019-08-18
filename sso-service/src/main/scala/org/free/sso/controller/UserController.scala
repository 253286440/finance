package org.free.sso.controller

import org.springframework.web.bind.annotation.{GetMapping, RequestMapping, RestController}
import reactor.core.publisher.Mono

/**
 * @author maheng
 */
@RestController
@RequestMapping(Array("api/user"))
class UserController {

  @GetMapping(Array("create"))
  def addUser():Mono[String] = {
    Mono.just("maheng")
  }
  @GetMapping(Array("get"))
  def getUser(id:String):Mono[String] = {
    Mono.just("maheng")
  }
}
