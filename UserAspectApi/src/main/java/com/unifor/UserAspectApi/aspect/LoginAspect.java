package com.unifor.UserAspectApi.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoginAspect {
    //Point cut para todos metodos publicos em controller
    @Pointcut("execution(public * com.unifor.UserAspectApi.controllers.*.*(..))")
    public void controllerMethod(){}

    //Advice Around: loga antes e depois, incluindo usuario autenticado
    @Around("controllerMethod()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = (auth != null && auth.isAuthenticated()) ? auth.getName() : "anonimo";

        System.out.println("Iniciando metodo :" + joinPoint.getSignature().getName() + "| Usuario: " + userName + " Args: " + joinPoint.getArgs());

        Object result = joinPoint.proceed(); //Executa o metodo apos o login

        System.out.println("Metodo conculido " + joinPoint.getSignature().getName() + "| Resultado: " + result);

        return result;
    }
}
