package joycai.springboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyConfig {

    /**
     * 全局的cors配置<br/>
     * 单个url的可以在方法上使用CrossOrigin注解
     * @return
     */
    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                //这里加入cors的访问路径
                registry.addMapping("/**");
            }
        };
    }
}
