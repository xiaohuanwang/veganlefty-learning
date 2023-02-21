package com.veganlefty.config;

import com.veganlefty.common.exception.AbstractGlobalExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * <p>全局异常处理</p>
 *
 * @author wxh_work@163.com
 * @date 2023/2/2 18:13
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler extends AbstractGlobalExceptionHandler {

}
