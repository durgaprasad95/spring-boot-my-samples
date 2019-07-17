package sample.aop.monitor;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServicePointCutsMonitor {

	@Pointcut("execution(* sample..*Service.*(..))")
	public void logServiceExecutionPointCut() {
	}

	@Pointcut(value = "@annotation(sample.aop.service.DefaultValueReturn)")
	public void logServiceAnnotaionPointCut() {
	}
}
