package joycai.springboot.controller;

import joycai.springboot.repository.UserRepository;
import joycai.springboot.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    UserAccountService userAccountService;

    @RequestMapping("test")
    public String test() {
        return "users 1";
    }
}
