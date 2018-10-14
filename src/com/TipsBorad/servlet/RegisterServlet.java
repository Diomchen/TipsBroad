package com.TipsBorad.servlet;

import com.TipsBorad.service.RegistService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private RegistService registService;
    @Override
    public void init() throws ServletException {
        super.init();
        registService = new RegistService();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String realname = request.getParameter("realname");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        boolean isExsit = registService.CheckUsernameAndPhone(username,phone);
        if(isExsit){
            request.getRequestDispatcher("/WEB-INF/biz/register.jsp").forward(request,response);
        }

    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
