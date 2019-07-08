package org.alan.jwt.controller;

import com.alibaba.fastjson.JSONObject;
import org.alan.jwt.annotation.UserLoginToken;
import org.alan.jwt.entity.SysUser;
import org.alan.jwt.service.TokenService;
import org.alan.jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: learn-security-jwt
 * @description:
 * @author: AlanMa
 * @create: 2019-07-08 14:42
 */
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    TokenService tokenService;

    @PostMapping("/login")
    public Object login(@RequestBody SysUser user){
        JSONObject jsonObject = new JSONObject();
        SysUser userForBase = userService.findByUsername(user);
        if(userForBase==null){
            jsonObject.put("message","登录失败,用户不存在");
            return jsonObject;
        }else {
            if (!userForBase.getPassword().equals(user.getPassword())){
                jsonObject.put("message","登录失败,密码错误");
                return jsonObject;
            }else {
                String token = tokenService.getToken(userForBase);
                jsonObject.put("token", token);
                jsonObject.put("user", userForBase);
                return jsonObject;
            }
        }
    }

    @UserLoginToken
    @GetMapping("/getMessage")
    public String getMessage(){
        return "你已通过验证";
    }
}
