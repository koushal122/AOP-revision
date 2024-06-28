package com.koushal.AspectOrientedProgramming.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {
    private Logger logger= LoggerFactory.getLogger(getClass());
    //here we have to define pointcut i.e. when?
    //here we have give package in which it needs to intercept in below pattern
    // execution(* PACKAGE.*.*(..))
    //below method will aspect before all classes and method under com.koushal.AspectOrientedProgramming
    @Before("execution(* com.koushal.AspectOrientedProgramming.*.*(..))")
    public void logMethodCalls(JoinPoint joinPoint){
        //here we will define/add logic how to aspect
        logger.info("Aspected method -> "+joinPoint);
    }
    //This will be called after every method execution under package com.koushal.AspectOrientedProgramming
    //and joinpoint has so many argument related to
    @After("execution(* com.koushal.AspectOrientedProgramming.*.*(..))")
    public void logMethodCallAfterExecution(JoinPoint joinPoint) {
        logger.info("After Aspect - {} has executed",  joinPoint);
    }

    //This is called after every method which throws exception under given package.
    @AfterThrowing(
            pointcut = "execution(* com.koushal.AspectOrientedProgramming.*.*(..))",
            throwing = "exception"
    )
    public void logMethodCallAfterException(JoinPoint joinPoint, Exception exception) {
        logger.info("AfterThrowing Aspect - {} has thrown an exception {}"
                ,  joinPoint, exception);
    }

    //This is called after returning every method but that method should execute successfully.
    @AfterReturning(
            pointcut = "execution(* com.in28minutes.learnspringaop.aopexample.*.*.*(..))",
            returning = "resultValue"
    )
    public void logMethodCallAfterSuccessfulExecution(JoinPoint joinPoint,
                                                      Object resultValue) {
        logger.info("AfterReturning Aspect - {} has returned {}"
                ,  joinPoint, resultValue);
    }

    //This method will be used to get time duration method is executed because @Around
    //annotation is used do something before and after execution of any method.
    @Around("execution(* com.in28minutes.learnspringaop.aopexample.*.*.*(..))")
    public Object findExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //Start a timer
        long startTimeMillis = System.currentTimeMillis();

        //Execute the method
        Object returnValue = proceedingJoinPoint.proceed();

        //Stop the timer
        long stopTimeMillis = System.currentTimeMillis();

        long executionDuration = stopTimeMillis - startTimeMillis;

        logger.info("Around Aspect - {} Method executed in {} ms",proceedingJoinPoint, executionDuration);

        return returnValue;
    }


}
