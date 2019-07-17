/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package sample.aop.monitor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAfterAdviceMonitor {

	@AfterReturning("execution(* sample..*Service.*(..))")
	public void logServiceAccess(JoinPoint joinPoint) {
		System.out.println("After Returning By pointcut expression: " + joinPoint);
	}

	@AfterThrowing(pointcut = "execution(* sample..*Service.*(..))", throwing = "e")
	public void logServiceErrorAccess(JoinPoint joinPoint, Exception e) {
		System.out.println("Thrown Exception  By pointcut expression: " + e.getMessage());
	}

	@After("execution(* sample..*Service.*(..))")
	public void logServiceAnyAccess(JoinPoint joinPoint) {
		System.out.println("After finally By pointcut expression: " + joinPoint);
	}

	@After("sample.aop.monitor.ServicePointCutsMonitor.logServiceExecutionPointCut()")
	public void logServiceAnyAccessByPointCut(JoinPoint joinPoint) {
		System.out.println("After By PointCut: " + joinPoint);
	}

	@After(value = "sample.aop.monitor.ServicePointCutsMonitor.logServiceAnnotaionPointCut()")
	public void logServiceAnyAccessByAnnotaionPointCut(JoinPoint joinPoint) {
		Object value = joinPoint.getStaticPart().getSignature();
		System.out.println("After By Annotaion PointCut: " + joinPoint);
	}
}
