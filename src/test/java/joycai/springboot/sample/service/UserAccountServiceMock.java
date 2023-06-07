package joycai.springboot.service;

import org.springframework.stereotype.Component;

@Component
public class UserAccountServiceMock implements UserAccountService {
    @Override
    public Long countUser() {
        return 2L;
    }
}
