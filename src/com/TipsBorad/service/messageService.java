package com.TipsBorad.service;

import com.TipsBorad.DAO.messageDAO;
import com.TipsBorad.bean.message;

import java.util.List;

public class messageService {

    public messageDAO mesgDAO;

    public messageService(){
        mesgDAO = new messageDAO();
    }

    public List<message> getMessage(int page,int size){
        return mesgDAO.getMessages(page,size);
    }

    public int getCountMessages(){
        return mesgDAO.conntMessage();
    }
}
