package joycai.springboot.sample.service.impl;


import joycai.springboot.sample.db.repository.UserRepository;
import joycai.springboot.service.UserAccountService;
import org.springframework.stereotype.Service;

@Service("UserAccountService")
public class UserAccountServiceImpl implements UserAccountService {

    private final UserRepository userRepository;

    public UserAccountServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Long countUser() {
        return userRepository.count();
    }
}
