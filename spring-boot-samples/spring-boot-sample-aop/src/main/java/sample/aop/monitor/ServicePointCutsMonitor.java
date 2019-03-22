package sample.aop.monitor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServicePointCutsMonitor {

	/*@Pointcut("execution(* sample..*Service.*(..))")
	public void logServiceExecutionPointCut(JoinPoint joinPoint) {
		System.out.println("Returned From: " + joinPoint);
	}*/

	@Pointcut("call(* sample..*Service.*(..))")
	public void logServiceCallPointCut(JoinPoint joinPoint) {
		System.out.println("came here");
	}
}
