package com.at.ct.web.service.impl;

import com.at.ct.web.bean.User;
import com.at.ct.web.dao.UserDao;
import com.at.ct.web.query.PageResult;
import com.at.ct.web.query.QueryObject;
import com.at.ct.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Integer save(User d) {
        return userDao.save(d);
    }

    @Override
    public Integer update(User d) {
        return userDao.update(d);
    }

    @Override
    public Integer delete(Integer id) {
        return userDao.delete(id);
    }

    @Override
    public User get(Integer id) {
        return userDao.get(id);
    }

    @Override
    public List<User> list() {
        return userDao.list();
    }

    @Override
    public List<User> query(QueryObject qo) {
        return null;
    }

    @Override
    public PageResult query3(QueryObject qo) {
        //从数据库查询总数
        Integer totalCount = userDao.queryForCount(qo);
        if(totalCount == 0){

            return new PageResult(qo.getCurrentPage(),qo.getPageSize(), Collections.EMPTY_LIST,totalCount);
        }
        //查询结果集数据
        List<User> list = userDao.queryForList(qo);
        return new PageResult(qo.getCurrentPage(),qo.getPageSize(),list,totalCount);
    }
}
