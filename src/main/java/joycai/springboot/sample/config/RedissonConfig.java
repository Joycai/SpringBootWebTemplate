package joycai.springboot.sample.config;

import com.google.common.base.Strings;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class RedissonConfig {

    @Value("${redis.url}")
    String url;
    @Value("${redis.pwd}")
    String pwd;

    /**
     * 初始化redis，需要在配置文件里配置redis地址和密码
     *
     * @return
     */
    @Bean(destroyMethod = "shutdown")
    public RedissonClient getRedisson() {
        Config config = new Config();
        SingleServerConfig singleServerConfig = config.useSingleServer();
        singleServerConfig.setConnectionPoolSize(200)
                .setConnectTimeout(1000)
                .setAddress("redis://" + url);
        if (!Strings.isNullOrEmpty(pwd)) {
            singleServerConfig.setPassword(pwd);
        }
        return Redisson.create(config);
    }
}
