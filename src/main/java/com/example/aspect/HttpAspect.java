package com.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by cw on 2017/5/10.
 */
@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    /**
     * 切点
     */
    @Pointcut("execution(public * com.example.controller.GirlController.girls(..))")
    public void log() {
        logger.info("111111");

    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        logger.info("2222");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("url={}", request.getRequestURL());
        logger.info("methond={}", request.getMethod());
        logger.info("ip={}", request.getRemoteAddr());

        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() +
                "." + joinPoint.getSignature().getName());

        logger.info("args={}", joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter() {
        logger.info("33333");
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {

        logger.info("respone={}", object.toString());
    }
}
