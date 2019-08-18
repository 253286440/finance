package org.free.discovery

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

/**
 * @author maheng
 */
object DiscoveryStarter {
  def main(args: Array[String]): Unit = {
    println("--------------------spring boot start----------------------------")
    SpringApplication.run(classOf[DiscoveryStarter],args:_*)
    println("--------------------spring boot end----------------------------")
  }
}

@SpringBootApplication
class DiscoveryStarter {

}
