package com.example.aopdemo.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

//    Pointcut Declaration
    @Pointcut("execution(* com.example.aopdemo.service.*.*(..))")
    private void matchAnyMethodInServicePackage() {}

//    @Before("execution(public void addAccount())") <- THIS MATCHES ON ANY public void addAccount() method call
//    @Before("execution(public void com.example.aopdemo.dao.AccountDAO.addAccount())") <- THIS MATCHES ON the public void addAccount() method of the AccountDAO class only
//    @Before("execution(* add*())") <- THIS MATCHES ANY METHOD THAT STARTS WITH "add" AND HAS ANY RETURN TYPE
//    @Before("execution(* add*(com.example.aopdemo.Account))") <- THIS MATCHES ANY METHOD THAT STARTS WITH "add" AND TAKES A PARAMETER OF TYPE "Account"
//    @Before("execution(* add*(com.example.aopdemo.Account, boolean))"  <- THIS MATCHES ANY METHOD THAT STARTS WITH "add" AND TAKES TWO PARAMETERS OF TYPE "Account" & "boolean"
//    @Before("execution(* add*(..))")   <- THIS MATCHES ANY METHOD THAT STARTS WITH "add" AND TAKES 0 or MORE ARGUMENTS
//    @Before("execution(* com.example.aopdemo.dao.*.*(..))") <- THIS MATCHES ANY METHOD INSIDE "dao" PACKAGE THAT TAKES 0 OR MORE ARGUMENTS
    @Before("matchAnyMethodInServicePackage()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n=====>>> Executing @Before advice on addAccount()");
    }
}
