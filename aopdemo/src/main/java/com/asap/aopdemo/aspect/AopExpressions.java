package com.asap.aopdemo.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class AopExpressions {
    @Pointcut("execution(* com.asap.aopdemo.dao.*.*(..))")
    public void forDaoPackage() {}

    @Pointcut("execution(* com.asap.aopdemo.dao.*.get*(..))")
    public void getter() {}

    @Pointcut("execution(* com.asap.aopdemo.dao.*.set*(..))")
    public void setter() {}

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter() {}
}
