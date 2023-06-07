package joycai.springboot.sample.db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(scanBasePackages = {"joycai.springboot.sample.service", "joycai.springboot.sample.db.repository"}, exclude = {SecurityAutoConfiguration.class})
public class JPARunner {
    public static void main(String[] args) {
        SpringApplication.run(JPARunner.class, args);
    }
}
