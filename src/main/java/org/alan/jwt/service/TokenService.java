package org.alan.jwt.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.alan.jwt.entity.SysUser;
import org.springframework.stereotype.Service;

/**
 * @program: learn-security-jwt
 * @description:
 * @author: AlanMa
 * @create: 2019-07-08 14:42
 */
@Service("TokenService")
public class TokenService {

    public String getToken(SysUser user) {

        String token;
        token= JWT.create().withAudience(String.valueOf(user.getId()))
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
}
