package com.mantou.cloud.service.serviceImpl;

import com.mantou.cloud.entities.Pay;
import com.mantou.cloud.mapper.PayMapper;
import com.mantou.cloud.service.PayService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName: PayServiceImpl
 * Package: com.mantou.cloud.service.serviceImpl
 * Description:
 *
 * @Author 馒头
 * @Create 2024/3/19 21:42
 * @Version 1.0
 */
@Service
public class PayServiceImpl implements PayService {
    @Resource
    private PayMapper payMapper;

    @Override
    public int addPay(Pay pay) {
        return payMapper.insertSelective(pay);
    }

    @Override
    public int deletePay(Integer id) {
        return payMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updatePay(Pay pay) {
        return payMapper.updateByPrimaryKey(pay);
    }

    @Override
    public Pay getPay(Integer id) {
        return payMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Pay> getAll() {
        return payMapper.selectAll();
    }
}
