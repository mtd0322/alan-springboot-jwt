package org.alan.jwt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: alan-springboot-jwt
 * @ClassName: TestController
 * @description:
 * @author: AlanMa
 * @create: 2019-07-08 16:48
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/abc")
    String getStr() {
        return "abc";
    }
}