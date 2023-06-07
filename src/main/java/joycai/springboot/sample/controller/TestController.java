package joycai.springboot.sample.controller;

import joycai.springboot.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private UserAccountService userAccountService;

    @Autowired
    public TestController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @RequestMapping("test")
    public String test() {
        return userAccountService.countUser() + "";
    }

}
