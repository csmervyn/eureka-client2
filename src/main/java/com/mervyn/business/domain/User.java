package com.mervyn.business.domain;


import org.hibernate.validator.constraints.NotBlank;

/**
 * @author hexinxin
 * Date: 2018/1/11
 * Time: 11:02
 * Description:用户实体
 */
public class User {
    private String id;
    @NotBlank(message = "用户名不能为空")
    private String name;
    @NotBlank(message = "密码不能为空")
    private String password;

    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
