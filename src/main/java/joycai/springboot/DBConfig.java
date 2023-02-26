package joycai.springboot;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories
@EnableTransactionManagement
public class DBConfig {

    /**
     * 在配置文件里写入url，username和password
     *
     * @param url
     * @param username
     * @param password
     * @return
     */
    @Bean(destroyMethod = "close")
    public HikariDataSource getDataSource(@Value("#{ serviceConfig['jdbc.url'] }") String url,
                                          @Value("#{ serviceConfig['jdbc.username'] }") String username,
                                          @Value("#{ serviceConfig['jdbc.password'] }") String password) {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(url);
        hikariConfig.setUsername(username);
        hikariConfig.setPassword(password);
        hikariConfig.setConnectionTestQuery("SELECT 1");
        hikariConfig.setReadOnly(false);
        hikariConfig.setConnectionTimeout(30000);
        hikariConfig.setValidationTimeout(10000);
        hikariConfig.setMaximumPoolSize(25);
        return new HikariDataSource(hikariConfig);
    }

    /**
     * 初始化redis，需要在配置文件里配置redis地址和密码
     *
     * @param url
     * @param pwd
     * @return
     */
    @Bean(destroyMethod = "shutdown")
    public RedissonClient getRedisson(@Value("#{ serviceConfig['redis.url'] }") String url, @Value("#{ serviceConfig['redis.pwd'] }") String pwd) {
        Config config = new Config();

        config.useSingleServer().setConnectionPoolSize(200)
                .setConnectTimeout(1000)
                .setAddress("redis://" + url)
                .setPassword(pwd);
        return Redisson.create(config);
    }
}
