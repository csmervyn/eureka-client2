package com.mervyn.business.controller;

import com.mervyn.business.service.AddService;
import com.mervyn.common.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author hexinxin
 * @Date: 2018/3/13
 * @Time: 13:11
 * @Description: 加计算服务提供者
 */
@RestController
@RequestMapping("compute")
public class ComputeController {
    @Value("${server.port}")
    String port;

    @Autowired
    private AddService addService;

    @RequestMapping(value = "/add",method= RequestMethod.GET)
    public JsonResult<Integer> add (@RequestParam Integer augend, @RequestParam Integer addend) {
        if(augend != null && addend != null) {
            Integer result = addService.add(augend,addend);
            return new JsonResult<Integer>(result,"计算成功；port：" + port,Boolean.TRUE);
        } else {
            return new JsonResult<Integer>(null,"计算失败port：" + port,Boolean.FALSE);
        }
    }
}
