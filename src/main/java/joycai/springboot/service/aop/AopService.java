package joycai.springboot.service.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class AopService {

    private Logger logger = LoggerFactory.getLogger(AopService.class);

    /**
     * 定义一个切面
     */
    @Pointcut(value = "execution(* joycai.springboot.service.impl.UserAccountServiceImpl.*(..))")
    public void aspect() {

    }

    @Around(value = "aspect()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("aop around");
        return joinPoint.proceed();
    }
}
