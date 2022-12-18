package example;

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.jdbc._
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = Array(classOf[DataSourceAutoConfiguration]))
class MyApp {}

object Application extends App {

 SpringApplication.run(classOf[MyApp]);

}
