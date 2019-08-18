package org.free.sso

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import tk.mybatis.spring.annotation.MapperScan

/**
 * @author maheng
 */
object SSOStarter {
  def main(args: Array[String]): Unit = {
    println("-----------------spring boot start-----------------------")
    SpringApplication.run(classOf[SSOStarter],args:_*)
    println("-----------------spring boot end-----------------------")
  }
}

@MapperScan(Array("org.free.sso.mapper"))
@SpringBootApplication
class SSOStarter {

}
