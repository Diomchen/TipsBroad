package com.TipsBorad.service;

import com.TipsBorad.DAO.UserDAO;

public class RegistService {
    private UserDAO userDAO;

    public RegistService(){
        userDAO = new UserDAO();
    }

    public boolean CheckUsernameAndPhone(String username,String phone){
        return userDAO.CheckUsernameAndPhone(username,phone);
    }

}
