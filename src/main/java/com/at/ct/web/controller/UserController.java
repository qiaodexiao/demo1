package com.at.ct.web.controller;

import com.at.ct.web.bean.User;
import com.at.ct.web.query.PageResult;
import com.at.ct.web.query.QueryObject;
import com.at.ct.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping("/querys")
    public String query(@ModelAttribute("qo") QueryObject qo, Model model){

        //调用业务的方法执行查询
        /*List<Dept> list = service.query(qo);
        model.addAttribute("list",list);*/


        PageResult result = service.query3(qo);

        model.addAttribute("result",result);


        return "list";
    }
    @RequestMapping("/list")
    public String list(Model model){
        List<User> list = service.list();
        model.addAttribute("list",list);
        return "list";
    }


    @RequestMapping("/edit")
    public String edit(Integer id, Model model){
        if(id!=null){
            model.addAttribute("user",service.get(id));
        }
        return "edit";
    }

    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(User dept){
        if(dept.getId()!=null){
            service.update(dept);
        }else{
            service.save(dept);
        }
        return "redirect:/querys";
    }

    @RequestMapping("/delete")
    public String delete(Integer id){
        if(id!=null){
            service.delete(id);
        }
        return "redirect:/querys";
    }
}
