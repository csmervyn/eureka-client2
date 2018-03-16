package com.mervyn.business.controller;

import com.mervyn.business.domain.User;
import com.mervyn.common.JsonResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author hexinxin
 * @Date: 2018/1/11
 * @Time: 11:21
 * @Description:UserController
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Value("${server.port}")
    String port;
    @RequestMapping(value = "/send",method= RequestMethod.POST)
    public JsonResult<Object> isExsit(@RequestBody @Valid User user, BindingResult result ){
        if(result.hasErrors()){
            return getErrors(result);
        }
        if(user.getName().isEmpty() || user.getPassword().isEmpty()){
            return new JsonResult<Object>(null,"用户不存在；port:"+ port,Boolean.FALSE);
        }else{
            return new JsonResult<Object>(null,"用户存在；port:"+ port,Boolean.TRUE);
        }
    }
    private JsonResult<Object> getErrors(BindingResult result){
        JsonResult<Object> jsonResult =  null;
        StringBuilder message = new StringBuilder();
        List<FieldError> list = result.getFieldErrors();
        for (FieldError error : list) {
            message.append(error.getDefaultMessage());
            message.append(";");
        }
        jsonResult = new JsonResult<Object>(null,message.toString(),Boolean.FALSE);
        return jsonResult;
    }
}
