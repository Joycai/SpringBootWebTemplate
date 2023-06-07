package joycai.springboot.sample.db;

import joycai.springboot.sample.config.DataSourceConfig;
import joycai.springboot.sample.config.RedissonConfig;
import joycai.springboot.sample.db.entity.UserEntity;
import joycai.springboot.sample.db.repository.UserRepository;
import joycai.springboot.sample.service.UserAccountService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

@SpringBootTest
@AutoConfigureTestDatabase
public class TestJPA {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserAccountService userAccountService;
    @MockBean
    RedissonConfig redissonConfig;
    @MockBean
    DataSourceConfig dataSourceConfig;

    @Test
    void baseTest() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName("my");
        userEntity.setPwd("pwd");
        userRepository.save(userEntity);
        Optional<UserEntity> findOpt = userRepository.findByUserName("my");
        Assertions.assertTrue(findOpt.isPresent());

        Assertions.assertEquals(1, userAccountService.countUser());
    }

}
