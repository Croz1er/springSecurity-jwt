package com.deer.utils.anno;

import java.lang.annotation.*;

/**
 * @author lujy
 * @version 1.0
 * @date 2020/10/16 13:16
 * 标记方法的返回值，是否需要包装
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
@Documented
public @interface ResponseResult {
}
