package com.veganlefty.annotation;

import java.lang.annotation.*;

/**
 *  防止重复提交锁
 *
 * @author wxh_work@163.com
 * @date 2023/2/20 10:57
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface LocalLock {
    
    /**
    * <p></p>
    * @author wxh_work@163.com
    * @date 2023/2/20 10:58
    * @return key key
    */
    String key() default "";
}
