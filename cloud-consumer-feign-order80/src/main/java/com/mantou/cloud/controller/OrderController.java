package com.mantou.cloud.controller;

import com.mantou.cloud.apis.PayFeignApi;
import com.mantou.cloud.entities.PayDTO;
import com.mantou.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName: OrderController
 * Package: com.mantou.cloud.controller
 * Description:
 *
 * @Author 馒头
 * @Create 2024/3/27 21:54
 * @Version 1.0
 */
@RestController
@RequestMapping("/feign")
public class OrderController {
    @Resource
    private PayFeignApi payFeignApi;
    @PostMapping("/pay/addPay")
    public ResultData addPay(@RequestBody PayDTO payDTO){
        return payFeignApi.addPay(payDTO);
    }
    @GetMapping("/pay/getPay/{id}")
    public ResultData getPay(@PathVariable("id") Integer id){
        return payFeignApi.getPay(id);
    }
    @GetMapping("/pay/getConsulInfo")
    public String getConsulInfo(){
        return payFeignApi.getConsulInfo();
    }
}
