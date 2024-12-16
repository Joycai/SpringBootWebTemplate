package joycai.springboot.sample.controller;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import joycai.springboot.sample.service.UserAccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(classes = {ControllerRunner.class})
@AutoConfigureMockMvc
class TestControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private UserAccountService userAccountService;

  @Test
  @WithMockUser
  void test() {
    try {
      when(userAccountService.countUser()).thenReturn(2L);
      mockMvc.perform(get("/test")).andExpect(status().isOk()).andExpect(content().string("2"));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
