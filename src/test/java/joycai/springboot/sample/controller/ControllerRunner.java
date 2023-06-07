package joycai.springboot.sample.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(scanBasePackages = {"joycai.springboot.sample.controller"}, exclude = {SecurityAutoConfiguration.class})
public class ControllerRunner {
    public static void main(String[] args) {
        SpringApplication.run(ControllerRunner.class, args);
    }
}
