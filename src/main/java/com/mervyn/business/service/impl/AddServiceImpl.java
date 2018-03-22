package com.mervyn.business.service.impl;

import com.mervyn.business.service.AddService;
import org.springframework.stereotype.Service;

/**
 * @author hexinxin
 * @Date: 2018/3/19
 * @Time: 14:56
 * @Description:
 */
@Service("addService")
public class AddServiceImpl implements AddService {
    @Override
    public Integer add(Integer augend, Integer addend) {
        return augend + addend;
    }
}
