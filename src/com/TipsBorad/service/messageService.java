package com.TipsBorad.service;

import com.TipsBorad.DAO.messageDAO;
import com.TipsBorad.bean.User;
import com.TipsBorad.bean.message;

import java.util.List;

public class messageService {

    private messageDAO mesgDAO;

    public messageService(){
        mesgDAO = new messageDAO();
    }

    public List<message> getMessage(int page,int size){
        return mesgDAO.getMessages(page,size);
    }

    public int getCountMessages(){
        return mesgDAO.countMessage();
    }

    public boolean upDateMessage(message msg){
        return mesgDAO.upDateMessage(msg);
    }
}
