package com.at.ct.web.dao;

import com.at.ct.web.bean.User;
import com.at.ct.web.query.QueryObject;

import java.util.List;

public interface UserDao {
    Integer save(User d);

    Integer update(User d);

    Integer delete(Integer id);

    User get(Integer id);

    List<User> list();

    List<User> query(QueryObject qo);

    Integer queryForCount(QueryObject qo);

    List<User> queryForList(QueryObject qo);
}
