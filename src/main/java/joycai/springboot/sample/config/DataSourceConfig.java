package joycai.springboot.sample.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EntityScan(basePackages = "joycai.springboot.sample.db.entity")
@EnableJpaRepositories(basePackages = "joycai.springboot.sample.db.repository")
@EnableTransactionManagement
@Configuration
public class DataSourceConfig {

    /**
     * 在配置文件里写入url，username和password
     *
     * @param url
     * @param username
     * @param password
     * @return
     */
    @Bean(destroyMethod = "close")
    public HikariDataSource getDataSource(@Value("${jdbc.url}") String url,
                                          @Value("${jdbc.username}") String username,
                                          @Value("${jdbc.password}") String password) {
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

}
