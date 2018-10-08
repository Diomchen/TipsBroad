package com.TipsBorad.servlet;

import com.TipsBorad.bean.User;
import com.TipsBorad.service.messageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "MessageServlet")
public class MessageServlet extends HttpServlet {
    private messageService msgsv;

    @Override
    public void init() throws ServletException {
        super.init();
        msgsv = new messageService();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User)request.getSession().getAttribute("username");

        String title = request.getParameter("title");
        String content = request.getParameter("content");

        if(Objects.equals("/addMessage.do",request.getServletPath())){
            boolean result =  msgsv.upDateMessage(title,content,user);
            if(result){
                request.getRequestDispatcher("/WEB-INF/biz/message_list.jsp").forward(request,response);
            }
            else{
                request.getRequestDispatcher("/WEB-INF/err/404.jsp").forward(request,response);
            }
        }
        else if(Objects.equals("/message/list.do",request.getServletPath())){

            request.getRequestDispatcher("/WEB-INF/biz/message_list.jsp").forward(request,response);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
