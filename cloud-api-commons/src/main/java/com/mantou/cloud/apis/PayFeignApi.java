package com.mantou.cloud.apis;

import com.mantou.cloud.entities.PayDTO;
import com.mantou.cloud.resp.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * ClassName: PayFeignApi
 * Package: com.mantou.cloud.apis
 * Description:
 *
 * @Author 馒头
 * @Create 2024/3/27 21:43
 * @Version 1.0
 */
@FeignClient("cloud-payment-service")
public interface PayFeignApi {
    @PostMapping("/pay/add")
    ResultData<String> addPay(@RequestBody PayDTO payDTO);
    @GetMapping("/pay/get/{id}")
    ResultData getPay(@PathVariable("id") Integer id);
    @GetMapping("/pay/getConsulInfo")
    String getConsulInfo();
}
