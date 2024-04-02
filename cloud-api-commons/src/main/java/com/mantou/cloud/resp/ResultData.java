package com.mantou.cloud.resp;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * ClassName: ResultData
 * Package: com.mantou.cloud.resp
 * Description:
 *
 * @Author 馒头
 * @Create 2024/3/23 15:54
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@Accessors(chain = true)
public class ResultData<T> {
    private String code;
    private String message;
    private T data;
    private long timestamp ;

    public ResultData (){
        this.timestamp = System.currentTimeMillis();
    }


    public static  <T> ResultData<T> success(T data){
        ResultData<T> resultData = new ResultData<>();
        resultData.setCode(ReturnCodeEnum.RC200.getCode());
        resultData.setMessage(ReturnCodeEnum.RC200.getMessage());
        resultData.setData(data);
        return  resultData;
    }

    public static <T> ResultData<T> fail(String code,String message){
        ResultData<T> resultData = new ResultData<>();
        resultData.setCode(code);
        resultData.setMessage(message);
        return  resultData;
    }
}
