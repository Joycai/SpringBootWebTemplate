package joycai.springboot.controller;

import joycai.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping("test")
    public String test() {
        Long userCount = userRepository.count();
        return userCount+" users";
    }
}
