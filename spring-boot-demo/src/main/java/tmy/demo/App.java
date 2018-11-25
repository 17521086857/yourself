package tmy.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

import static org.springframework.web.bind.annotation.RequestMethod.GET;



@SpringBootApplication
@RestController
@MapperScan(basePackages="tmy.demo.*.mapper")
@EnableSwagger2
@EnableScheduling
public class App {

    @RequestMapping(value = "/", method = GET)
    public String index() {
        return "Hello World!";
    }
   
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
