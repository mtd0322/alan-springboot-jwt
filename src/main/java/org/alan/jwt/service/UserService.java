package org.alan.jwt.service;

import org.alan.jwt.entity.SysUser;
import org.alan.jwt.repository.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: learn-security-jwt
 * @description:
 * @author: AlanMa
 * @create: 2019-07-08 14:42
 */
@Service("UserService")
public class UserService {

    @Autowired
    SysUserRepository sysUserRepository;

    public SysUser findByUsername(SysUser user){
        return sysUserRepository.findSysUserByUsername(user.getUsername());
    }
    public SysUser findUserById(Long userId) {
        return sysUserRepository.findById(userId).orElse(null);
    }

}
