package com.TipsBorad.servlet;

import com.TipsBorad.common.CodeUtil;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.RenderedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "VerifingServlets")
public class VerifingServlets extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String,Object> map = CodeUtil.generateVirefyCode();

        Cookie cookie = new Cookie("v_c_v",map.get("code").toString());
        response.addCookie(cookie);
        System.out.println(map.get("code").toString());

        //禁止图像缓存
        response.setHeader("Pragma","no-cache");
        response.setHeader("Cache-Control","no-cache");
        response.setDateHeader("Expires",-1);

        response.setContentType("image/jpeg");

        ServletOutputStream sos;
        sos = response.getOutputStream();
        ImageIO.write((RenderedImage)map.get("codePic"),"jpeg",sos);
        sos.close();

    }
}
