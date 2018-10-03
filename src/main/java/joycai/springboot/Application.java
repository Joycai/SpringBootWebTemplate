package joycai.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

/**
 * application boot entry
 */
@EnableScheduling
@SpringBootApplication
public class Application {

    static Logger logger = LoggerFactory.getLogger(Application.class);

    static boolean debugMode = true;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * 用于获取启动参数
     * @param args
     */
    @Autowired
    public Application(ApplicationArguments args) {
        debugMode = !args.containsOption("release");
        List<String> files = args.getNonOptionArgs();

        logger.info(debugMode ? "run in debug" : "run in release");
    }

    /**
     * 载入配置文件
     * @return
     */
    @Bean(name = "serviceConfig")
    public Properties appConfig() {
        try {
            Properties p = new Properties();

            Resource frs = new FileSystemResource("serverconfig.properties");
            if (frs.exists()) {
                logger.info("加载外部配置文件");
                p.load(frs.getInputStream());
            } else {
                logger.info("加载默认配置文件");
                if (debugMode) {
                    //加载测试配置
                    Resource rs = new ClassPathResource("debug.properties");
                    p.load(rs.getInputStream());
                } else {
                    //加载生产配置
                    Resource rs = new ClassPathResource("release.properties");
                    p.load(rs.getInputStream());
                }
            }
            return p;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
