package joycai.springboot.service.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
public class AopService {

    Logger logger = LoggerFactory.getLogger(AopService.class);

    @Pointcut("execution(* joycai.springboot.service.impl.UserAccountServiceImpl.*(..))")
    public void aspect() {

    }

    @Around("aspect()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("aop around");
        return joinPoint.proceed();
    }
}
