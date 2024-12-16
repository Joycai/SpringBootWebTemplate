package joycai.springboot.sample.db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"joycai.springboot.sample.service",
    "joycai.springboot.sample.db.repository"})
public class JPARunner {

  public static void main(String[] args) {
    SpringApplication.run(JPARunner.class, args);
  }
}
