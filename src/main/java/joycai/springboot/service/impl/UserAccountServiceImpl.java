package joycai.springboot.service.impl;

import joycai.springboot.repository.UserRepository;
import joycai.springboot.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserAccountService")
public class UserAccountServiceImpl implements UserAccountService {
    @Autowired
    UserRepository userRepository;


    @Override
    public Long countUser() {
        return userRepository.count();
    }
}
