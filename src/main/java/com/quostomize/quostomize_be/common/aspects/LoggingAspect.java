package com.quostomize.quostomize_be.common.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


@Aspect
@Component
@Slf4j
public class LoggingAspect {

    /**
     * Before: 대상 메서드가 실행되기 전에 Advice를 실행
     *
     * @param joinPoint
     */
    @Before("execution(* com.quostomize.quostomize_be.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        log.info("Before: " + joinPoint.getSignature().getName());
    }

    /**
     * After : 대상 메서드가 실행된 후에 Advice를 실행
     *
     * @param joinPoint
     */
    @After("execution(* com.quostomize.quostomize_be.*.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        log.info("After: " + joinPoint.getSignature().getName());
    }


    /**
     * AfterReturning: 대상 메서드가 정상적으로 실행되고 반환된 후에 Advice를 실행
     *
     * @param joinPoint
     * @param result
     */
    @AfterReturning(pointcut = "execution(* com.quostomize.quostomize_be.*.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        log.info("AfterReturning: " + joinPoint.getSignature().getName() + " result: " + result);
    }

    /**
     * AfterThrowing: 대상 메서드에서 예외가 발생했을 때 Advice를 실행
     *
     * @param joinPoint
     * @param e
     */
    @AfterThrowing(pointcut = "execution(* com.quostomize.quostomize_be.*.*(..))", throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
        log.info(
                "AfterThrowing: " + joinPoint.getSignature().getName() + " exception: " + e.getMessage());
    }

    /**
     * Around : 대상 메서드 실행 전, 후 또는 예외 발생 시에 Advice를 실행
     *
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("execution(* com.quostomize.quostomize_be.*.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("Around before: " + joinPoint.getSignature().getName());
        Object result = joinPoint.proceed();
        log.info("Around after: " + joinPoint.getSignature().getName());
        return result;
    }

}