package com.TipsBorad.servlet;

import com.TipsBorad.bean.User;
import com.TipsBorad.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.logging.SimpleFormatter;

@WebServlet(name = "UserServlet")
public class UserServlet extends HttpServlet {
    private UserService userService;
    @Override
    public void init() throws ServletException {
        super.init();
        userService = new UserService();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(Objects.equals("/userInfo.do",request.getContextPath())){
            request.getRequestDispatcher("/WEB-INF/biz/user.jsp").forward(request,response);
        }
        else if(Objects.equals("/editUserPrompt.do",request.getContextPath())){
            Long id = Long.valueOf(request.getParameter("id"));
            User user = userService.getUserById(id);
            if(user != null){
                request.setAttribute("user",user);
                request.getRequestDispatcher("/WEB-INF/biz/edit_user.jsp").forward(request,response);
            }
            else{
                request.getRequestDispatcher("/WEB-INF/biz/user.jsp").forward(request,response);
            }
        }
        else if(Objects.equals("/editUser.do",request.getContextPath())){
            Long id = Long.valueOf(request.getParameter("id"));
            String name = request.getParameter("name");
            String password = request.getParameter("password");
            String realName = request.getParameter("realName");
            String birthday = request.getParameter("birthday");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");
            User user = null;
            try {
                user = new User(id,name,password,realName,new SimpleDateFormat("yyyy-MM-dd").parse(birthday),phone,address);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            boolean result = userService.upDate(user);

        }
        else{
            request.getRequestDispatcher("/WEB-INF/err/404.jsp").forward(request,response);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
