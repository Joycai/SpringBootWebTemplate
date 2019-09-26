package joycai.springboot;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executors;

/**
 * 独立的定时任务线程池
 */
@Configuration
@EnableScheduling
public class SchedulingConfig implements SchedulingConfigurer {
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        int coreNum = Runtime.getRuntime().availableProcessors();
        taskRegistrar.setScheduler(Executors.newScheduledThreadPool(coreNum*2));
    }
}
