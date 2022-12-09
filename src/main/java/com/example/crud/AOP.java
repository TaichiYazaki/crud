package com.example.crud;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AOP {
    
    @Before("execution(* com.example.crud.*Controller.*(..))")
    public void startLog(){
        System.out.println("処理開始");
    }
}
