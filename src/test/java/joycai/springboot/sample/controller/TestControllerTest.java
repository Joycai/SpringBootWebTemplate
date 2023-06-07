package joycai.springboot.controller;

import joycai.springboot.repository.UserRepository;
import joycai.springboot.service.UserAccountService;
import joycai.springboot.service.UserAccountServiceMock;
import org.junit.jupiter.api.Test;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import reactor.core.publisher.Mono;

import javax.persistence.EntityManagerFactory;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TestController.class)
@AutoConfigureMockMvc
public class TestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private EntityManagerFactory entityManagerFactory;

    @MockBean
    private RedissonClient redisson;

    @MockBean
    private UserAccountService userAccountService;

    @Test
    public void test(){
        try {
            when(userAccountService.countUser()).thenReturn(2L);
            mockMvc.perform(get("/test")).andExpect(status().isOk()).andExpect(content().string("2"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
