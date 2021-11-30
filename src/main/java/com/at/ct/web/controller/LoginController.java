package com.at.ct.web.controller;

import com.at.ct.web.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private LoginService service;

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/api/login")
    public String login(String username, String password, HttpSession session){
        System.out.println(username+" "+password);
        //调用业务方法
        Boolean res = service.login(username, password);
        if(res){
            //把登录的用户存入session作用域
            session.setAttribute("User","rose");
            return "redirect:/querys";
        }else{
            return "redirect:/index.jsp";
        }
    }

}
