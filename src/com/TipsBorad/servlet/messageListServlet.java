package com.TipsBorad.servlet;

import com.TipsBorad.bean.message;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "messageListServlet")
public class messageListServlet extends HttpServlet {
    private message mesg;
    @Override
    public void init() throws ServletException {
        super.init();
        mesg = new message();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pagestr = request.getParameter("page");
        int page = 1;
        if(pagestr!=null && Objects.equals("",pagestr)){
            page = Integer.parseInt(pagestr);
        }

        messageService.getMessage();



    }

    @Override
    public void destroy() {
        super.destroy();
        mesg = null;
    }
}
