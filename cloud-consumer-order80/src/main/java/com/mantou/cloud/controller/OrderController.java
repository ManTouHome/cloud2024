package com.mantou.cloud.controller;

import com.mantou.cloud.entities.PayDTO;
import com.mantou.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * ClassName: OrderController
 * Package: com.mantou.cloud.controller
 * Description:
 *
 * @Author 馒头
 * @Create 2024/3/23 16:03
 * @Version 1.0
 */
@RestController
@RequestMapping("/consumer")
public class OrderController {
    @Resource
    private RestTemplate restTemplate;
    /**
     * 新增订单
     */
    private final String SERVER_ADDERS = "http://cloud-payment-service";
    @PostMapping("/pay/add")
    public ResultData<String> addOrder(@RequestBody PayDTO payDTO){
        ResultData resultData = restTemplate.postForObject(SERVER_ADDERS + "/pay/add", payDTO, ResultData.class);
        return resultData;
    }
    /**
     *删除支付流水
     */
    @DeleteMapping("/pay/delete/{id}")
    public ResultData<Integer> deletePay(@PathVariable("id") Integer id) {
         restTemplate.delete(SERVER_ADDERS+"/pay/delete/" + id);
        return ResultData.success(1);
    }
    /**
     * 更新支付流水
     */
    @PutMapping("/pay/update")
    public ResultData<Integer> updatePay(@RequestBody PayDTO payDTO){
        restTemplate.put(SERVER_ADDERS+"/pay/update" ,payDTO);
        return ResultData.success(1);
    }
    /**
     * 获取支付流水
     */
    @GetMapping("/pay/get/{id}")
    public ResultData getPay(@PathVariable("id")Integer id){
        return restTemplate.getForObject(SERVER_ADDERS+"/pay/get/"+id,ResultData.class,id);
    }
    @GetMapping(value = "/pay/getConsulInfo")
    private String getInfoByConsul()
    {
        return restTemplate.getForObject(SERVER_ADDERS + "/pay/getConsulInfo", String.class);
    }
}
