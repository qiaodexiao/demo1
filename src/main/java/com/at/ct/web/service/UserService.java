package com.at.ct.web.service;

import com.at.ct.web.bean.User;
import com.at.ct.web.query.PageResult;
import com.at.ct.web.query.QueryObject;

import java.util.List;


public interface UserService {
    Integer save(User d);

    Integer update(User d);

    Integer delete(Integer id);

    User get(Integer id);

    List<User> list();

    List<User> query(QueryObject qo);



    PageResult query3(QueryObject qo);
}
