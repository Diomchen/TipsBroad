package com.TipsBorad.service;

import com.TipsBorad.DAO.UserDAO;
import com.TipsBorad.bean.User;

public class UserService {
    private UserDAO userDao;

    public UserService(){
        userDao = new UserDAO();
    }

    public User getUsers(String username,String password){
        return userDao.getUser(username,password);
    }

    public User getUserById(Long id){
        return userDao.getUserById(id);
    }
    public boolean upDate(User user){
        return upDate(user);
    }

}
