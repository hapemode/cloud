package com.ppx.user.common;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 定义全局异常 todo
 */
@Data
@AllArgsConstructor
public class BasicException extends RuntimeException {
    // 状态码
    private Integer code;
    // 错误信息
    private String message;

}
