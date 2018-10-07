package com.TipsBorad.servlet;

import com.TipsBorad.bean.User;
import com.TipsBorad.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {

    private UserService ues;
    @Override
    public void init() throws ServletException {
        super.init();
        ues = new UserService();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User u = ues.getUsers(username,password);
        if(username != null){
            request.getSession().setAttribute("user",u);
            request.getRequestDispatcher("/message/list.do").forward(request,response);
        }
        else{
            request.getRequestDispatcher("/login.do").forward(request,response);
        }
//        if(username != null && !Objects.equals(username,"") && password != null && !Objects.equals(password,"")){
//
//        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}



