package com.intech.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.java.Log;


@Aspect
@Log
@Configuration
public class LogAspect {

	//@Pointcut("execution(public * com.intech.controllers.SuperheroController.*(..))")
	@Pointcut("@annotation(io.swagger.annotations.ApiOperation) && execution(* *(..))")
	public void controllers() {

	}
	
	@Autowired
	private MeterRegistry registry;

	@Around("controllers()")
	public Object log(ProceedingJoinPoint pjp) throws Throwable {
		log.info("CONTROLLER : " + pjp.toString());
		registry.counter(pjp.getSignature().getName()).increment();
		return pjp.proceed();
	}

}
