package joycai.springboot.sample.controller;

import joycai.springboot.sample.db.repository.UserRepository;
import org.mockito.Mockito;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = {
    "joycai.springboot.sample.controller",
    "joycai.springboot.sample.service"})
public class ControllerRunner {

  @Bean
  public UserRepository userRepository() {
    return Mockito.mock(UserRepository.class);
  }

  public static void main(String[] args) {
    SpringApplication.run(ControllerRunner.class, args);
  }
}
