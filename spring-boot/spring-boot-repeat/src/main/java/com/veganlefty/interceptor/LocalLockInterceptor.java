package com.veganlefty.interceptor;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.veganlefty.annotation.LocalLock;
import com.veganlefty.common.response.ServiceStatus;
import com.veganlefty.config.SystemIllegalException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * 拦截器
 *
 * @author wxh_work@163.com
 * @date 2023/2/20 11:00
 */
@Aspect
@Configuration
public class LocalLockInterceptor {

    /**
     * 定义缓存，设置最大缓存数及过期日期
     * 最大缓存1000个
     * 设置写入缓存后10秒过期
     */
    private static final Cache<String,Object> CACHE = CacheBuilder.newBuilder().
            maximumSize(1000).expireAfterWrite(10, TimeUnit.SECONDS).build();

    @Around("execution(public * *(..))  && @annotation(com.veganlefty.annotation.LocalLock)")
    public Object interceptor(ProceedingJoinPoint joinPoint){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        LocalLock localLock = method.getAnnotation(LocalLock.class);
        String key = getKey(localLock.key(),joinPoint.getArgs());
        System.out.println("===> " + key);
        if(!StringUtils.isEmpty(key)){
            if(CACHE.getIfPresent(key) != null){
                throw new SystemIllegalException(ServiceStatus.GENERAL.DUPLICATE_REQUEST);
            }
            CACHE.put(key,key);
        }
        try{
            return joinPoint.proceed();
        }catch (Throwable throwable){
            throw new SystemIllegalException(ServiceStatus.GENERAL.SERVICE_ERROR);
        }finally {

        }
    }

    private String getKey(String keyExpress, Object[] args){
        for (int i = 0; i < args.length; i++) {
            keyExpress = keyExpress.replace("arg[" + i + "]", args[i].toString());
        }
        return keyExpress;
    }
}
