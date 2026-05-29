package re.dgnl.it211_session14_hackathon.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {
    @Before("execution(* re.dgnl.it211_session14_hackathon.service.impl.PostServiceImpl.*(..))")
    public void logMethodName(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        log.info("Đang thực thi phương thức: {}", methodName);
    }
}