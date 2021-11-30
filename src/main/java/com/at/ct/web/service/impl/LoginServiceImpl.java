package com.at.ct.web.service.impl;

import com.at.ct.web.service.LoginService;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Override
    public Boolean login(String username, String password) {
        if("admin".equals(username)  && "123".equals(password)){
            return true;
        }else {
            return false;
        }
    }
}
