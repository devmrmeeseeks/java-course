package com.asap.aopdemo.aspect;

import com.asap.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Order(2)
@Component
public class MyDemoLoggingAspect {
//    @Before("execution(public void addAccount())")
//    @Before("execution(public void com.asap.aopdemo.dao.AccountDao.addAccount())")
//    @Before("execution(public void add*())")
//    @Before("execution(* add*())")
//    @Before("execution(* add*(com.asap.aopdemo.Account))")
//    @Before("execution(* add*(com.asap.aopdemo.Account, ..))")
//    @Before("execution(* add*(..))")
//    @Before("execution(* com.asap.aopdemo.dao.*.*(..))")

    @Before("com.asap.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("\n=====>>> Executing @Before advice on addAccount()");
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method: " + methodSignature);

        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            System.out.println(arg);
            if (arg instanceof Account) {
                Account account = (Account) arg;
                System.out.println("Account name: " + account.getName());
                System.out.println("Account level: " + account.getLevel());
            }
        }
    }

    @AfterReturning(
            pointcut = "execution(* com.asap.aopdemo.dao.AccountDao.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @AfterReturning on method: " + method);
        System.out.println("\n=====>>> before result is: " + result);

        convertAccountNamesToUpperCase(result);
        System.out.println("\n=====>>> after result is: " + result);
    }

    @AfterThrowing(
            pointcut = "execution(* com.asap.aopdemo.dao.AccountDao.findAccounts(..))",
            throwing = "theExc"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable theExc) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @AfterThrowing on method: " + method);
        System.out.println("\n=====>>> The exception is: " + theExc);
    }

    @After("execution(* com.asap.aopdemo.dao.AccountDao.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @After (finally) on method: " + method);
    }

    @Around("execution(* com.asap.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String method = proceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @Around on method: " + method);

        Object result = null;

        try {
            long begin = System.currentTimeMillis();
            result = proceedingJoinPoint.proceed();
            long end = System.currentTimeMillis();
            long duration = end - begin;
            System.out.println("\n=====>>> Duration: " + duration / 1000.0 + " seconds");
            return result;
        } catch (Exception e) {
            System.out.println("@Around: We have a problem: " + e);
            throw e;
        }
    }



    private void convertAccountNamesToUpperCase(List<Account> result) {
        for(Account account : result) {
            account.setName(account.getName().toUpperCase());
        }
    }
}
