package com.mantou.cloud.service;

import com.mantou.cloud.entities.Pay;

import java.util.List;

/**
 * ClassName: PayService
 * Package: com.mantou.cloud.service
 * Description:
 *
 * @Author 馒头
 * @Create 2024/3/19 21:40
 * @Version 1.0
 */
public interface PayService {
    int addPay(Pay pay);
    int deletePay(Integer id);
    int updatePay(Pay pay);
    Pay getPay(Integer id);
    List<Pay> getAll();
}
