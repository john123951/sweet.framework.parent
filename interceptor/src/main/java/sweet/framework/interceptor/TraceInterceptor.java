package sweet.framework.interceptor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * Created by sweet on 1/1/17.
 */
@Aspect
@Component
public class TraceInterceptor {

//    @Around("@annotation(sweet.framework.interceptor.annotation.Trace)")
    //@Around("execution(public * *(..))")
    @Around("@within(sweet.framework.interceptor.annotation.Trace)")
    public Object process(ProceedingJoinPoint call) throws Throwable {
        StopWatch clock = new StopWatch("Profiling for '");
        try {
            clock.start(call.toShortString());
            return call.proceed();
        } finally {
            clock.stop();
            System.out.println(clock.prettyPrint());
        }
    }
}
