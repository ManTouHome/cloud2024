package com.mantou.cloud.controller;

import com.mantou.cloud.entities.Pay;
import com.mantou.cloud.entities.PayDTO;
import com.mantou.cloud.resp.ResultData;
import com.mantou.cloud.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * ClassName: PayController
 * Package: com.mantou.cloud.controller
 * Description:
 *
 * @Author 馒头
 * @Create 2024/3/19 21:52
 * @Version 1.0
 */
@RestController
@RequestMapping("/pay")
@Slf4j
@Tag(name = "支付微服务模块",description = "支付CRUD")
public class PayController {
    @Resource
    private PayService payService;
    /**
     * 新增一条支付流水
     */
    @PostMapping("/add")
    @Operation(summary = "新增",description = "新增支付流水方法,json串做参数")
    public ResultData<String> addPay(@RequestBody PayDTO payDTO){
        log.info(payDTO.toString());
        Pay pay = new Pay();
        BeanUtils.copyProperties(payDTO,pay);
        int i = payService.addPay(pay);
        return ResultData.success("成功插入记录，返回值"+i);
    }
    /**
     * 根据id删除一条支付流水
     */
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "删除",description = "删除支付流水方法")
    public ResultData<Integer> deletePay(@PathVariable("id") Integer id){
        int i = payService.deletePay(id);
        return ResultData.success(i);
    }
    /**
     * 更新一条支付流水
     */
    @PutMapping("/update")
    @Operation(summary = "修改",description = "修改支付流水方法")
    public ResultData<String> updatePay(@RequestBody PayDTO payDTO){
        log.info(payDTO.toString());
        Pay pay = new Pay();
        Date date = new Date();
        BeanUtils.copyProperties(payDTO,pay);
        pay.setDeleted((byte) 0);
        pay.setCreateTime(date);
        pay.setUpdateTime(date);
        int i = payService.updatePay(pay);
        return ResultData.success("成功更新记录，返回值"+i);
    }
    /**
     * 根据id查询支付流水
     */
    @GetMapping("/get/{id}")
    @Operation(summary = "按照ID查流水",description = "查询支付流水方法")
    public ResultData<Pay> getPay(@PathVariable("id") Integer id){
        Pay pay = payService.getPay(id);
        return ResultData.success(pay);
    }
    /**
     * 获取所有支付流水
     */
    @GetMapping("/getAll")
    @Operation(summary = "查询所有支付流水",description = "查询所有支付流水的方法")
    public ResultData<List<Pay>> getAll(){
        List<Pay> payList = payService.getAll();
        return ResultData.success(payList);
    }
    /**
     * 测试consul获取配置信息
     */
    @Value("${server.port}")
    private String port;
    @GetMapping("/getConsulInfo")
    public String getConsulInfo(@Value("${mantou.info}") String mantouInfo){
        return mantouInfo + "port: " + port;
    }
}
