package joycai.springboot;

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
     * boot 2.0+之后内置了HikariCP，因而更新了配置
     * @param url
     * @param username
     * @param password
     * @return
     */
    @Bean(destroyMethod = "shutdown")
    public DataSource getDataSource(@Value("#{ serviceConfig['mysql.url'] }") String url,
                                    @Value("#{ serviceConfig['mysql.username'] }") String username,
                                    @Value("#{ serviceConfig['mysql.password'] }") String password) {


        HikariDataSource ds = new HikariDataSource();

        ds.setJdbcUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setConnectionTestQuery("SELECT 1");
        ds.setReadOnly(false);
        ds.setConnectionTimeout(30000);
        ds.setValidationTimeout(10000);
        ds.setMaximumPoolSize(25);

        return ds;
    }

    /**
     * 初始化redis
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
        return  Redisson.create(config);
    }
}
