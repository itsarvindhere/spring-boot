package com.example.aopdemo.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class LoggingAspect extends PointcutDeclarations {

//    @Before("execution(public void addAccount())") <- THIS MATCHES ON ANY public void addAccount() method call
//    @Before("execution(public void com.example.aopdemo.dao.AccountDAO.addAccount())") <- THIS MATCHES ON the public void addAccount() method of the AccountDAO class only
//    @Before("execution(* add*())") <- THIS MATCHES ANY METHOD THAT STARTS WITH "add" AND HAS ANY RETURN TYPE
//    @Before("execution(* add*(com.example.aopdemo.Account))") <- THIS MATCHES ANY METHOD THAT STARTS WITH "add" AND TAKES A PARAMETER OF TYPE "Account"
//    @Before("execution(* add*(com.example.aopdemo.Account, boolean))"  <- THIS MATCHES ANY METHOD THAT STARTS WITH "add" AND TAKES TWO PARAMETERS OF TYPE "Account" & "boolean"
//    @Before("execution(* add*(..))")   <- THIS MATCHES ANY METHOD THAT STARTS WITH "add" AND TAKES 0 or MORE ARGUMENTS
//    @Before("execution(* com.example.aopdemo.dao.*.*(..))") <- THIS MATCHES ANY METHOD INSIDE "dao" PACKAGE THAT TAKES 0 OR MORE ARGUMENTS
    @Before("matchAnyMethodInDaoPackage() && !matchGetterAndSetterMethodsInDaoPackage()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method Signature is :" + methodSignature);

        Object[] args = joinPoint.getArgs();
        System.out.println("Method arguments are: ");
        for(Object arg: args) {
            System.out.println(arg);
        }
        System.out.println("\n=====>>> Executing @Before advice on addAccount()");
    }

}
