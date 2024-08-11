package com.example.aopdemo.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

//    Pointcut Declarations

    @Pointcut("execution(* com.example.aopdemo.dao.*.*(..))")
    private void matchAnyMethodInDaoPackage() {}

    @Pointcut("execution(* com.example.aopdemo.dao.*.get*(..))")
    private void matchGetterMethodsInDaoPackage() {}

    @Pointcut("execution(* com.example.aopdemo.dao.*.set*(..))")
    private void matchSetterMethodsInDaoPackage() {}

    @Pointcut("matchGetterMethodsInDaoPackage() || matchSetterMethodsInDaoPackage()")
    private void matchGetterAndSetterMethodsInDaoPackage() {}

//    @Before("execution(public void addAccount())") <- THIS MATCHES ON ANY public void addAccount() method call
//    @Before("execution(public void com.example.aopdemo.dao.AccountDAO.addAccount())") <- THIS MATCHES ON the public void addAccount() method of the AccountDAO class only
//    @Before("execution(* add*())") <- THIS MATCHES ANY METHOD THAT STARTS WITH "add" AND HAS ANY RETURN TYPE
//    @Before("execution(* add*(com.example.aopdemo.Account))") <- THIS MATCHES ANY METHOD THAT STARTS WITH "add" AND TAKES A PARAMETER OF TYPE "Account"
//    @Before("execution(* add*(com.example.aopdemo.Account, boolean))"  <- THIS MATCHES ANY METHOD THAT STARTS WITH "add" AND TAKES TWO PARAMETERS OF TYPE "Account" & "boolean"
//    @Before("execution(* add*(..))")   <- THIS MATCHES ANY METHOD THAT STARTS WITH "add" AND TAKES 0 or MORE ARGUMENTS
//    @Before("execution(* com.example.aopdemo.dao.*.*(..))") <- THIS MATCHES ANY METHOD INSIDE "dao" PACKAGE THAT TAKES 0 OR MORE ARGUMENTS
    @Before("matchAnyMethodInDaoPackage() && !matchGetterAndSetterMethodsInDaoPackage()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n=====>>> Executing @Before advice on addAccount()");
    }

    @Before("matchAnyMethodInDaoPackage() && !matchGetterAndSetterMethodsInDaoPackage()")
    public void performApiAnalytics() {
        System.out.println("\n=====>>> Performing API analytics");
    }

    @Before("matchAnyMethodInDaoPackage() && !matchGetterAndSetterMethodsInDaoPackage()")
    public void forAllDaoMethodsExceptGetterSetters() {
        System.out.println("\n=====>>> This advice won't be applied to getters and setters of the 'dao' package");
    }
}
