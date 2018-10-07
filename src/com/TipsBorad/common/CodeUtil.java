package com.TipsBorad.common;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CodeUtil {
    public static Map<String,Object> generateVirefyCode(){
        BufferedImage buffImg = new BufferedImage(100,40,BufferedImage.TYPE_INT_RGB);

        Graphics2D gp = (Graphics2D) buffImg.getGraphics();

        gp.setColor(Color.WHITE);
        gp.fillRect(0,0,100,40);

        Random rand = new Random();
        Font font = new Font("Fixedsys",Font.BOLD,35);
        gp.setFont(font);

        StringBuffer Codestr = new StringBuffer();
        int red = 0;
        int green = 0;
        int blue = 0;

        char[] ch = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
                '0','1','2','3','4','5','6','7','8','9'};

        for(int i=0 ; i<4 ; i++){
            String code = String.valueOf(ch[rand.nextInt(36)]);
            red = rand.nextInt(255);
            green = rand.nextInt(255);
            blue = rand.nextInt(255);

            gp.setColor(new Color(red,green,blue));
            gp.drawString(code,(i+1)*18,32);

            Codestr.append(code);
        }

        gp.setColor(Color.BLACK);
        for(int i = 0 ; i<20 ; i++){
            int x = rand.nextInt(100);
            int y = rand.nextInt(40);
            int x1 = rand.nextInt(10);
            int y1 = rand.nextInt(10);
            gp.drawLine(x,y,x1+x,y+y1);
        }
        Map<String,Object> map = new HashMap<>();
        map.put("code",Codestr);
        map.put("codePic",buffImg);
        return map;
    }
}
