package com.mantou.cloud.exception;

import com.mantou.cloud.resp.ResultData;
import com.mantou.cloud.resp.ReturnCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * ClassName: GlobalExceptionHandler
 * Package: com.mantou.cloud.exception
 * Description:
 *
 * @Author 馒头
 * @Create 2024/3/23 16:12
 * @Version 1.0
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultData<String> exception(Exception e){
        log.error("全局异常处理：{}",e.getMessage());
        return ResultData.fail(ReturnCodeEnum.RC500.getCode(), e.getMessage());
    }
}
