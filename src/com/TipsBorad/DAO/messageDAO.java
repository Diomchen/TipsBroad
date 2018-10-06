package com.TipsBorad.DAO;

import com.TipsBorad.bean.message;
import com.TipsBorad.common.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class messageDAO {
    public List<message> getMessages(int page, int size){
        Connection conn = ConnectionUtil.getConnection();

        String sql = "select * from message order by create_time desc limit ?,?;";//从第m条开始取出n条

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1,(page - 1 )* size);
            stmt.setInt(2,size);
        } catch (SQLException e) {
            System.out.println("sql语句解析错误");
            e.printStackTrace();
        }


        return null;
    }



}
