package com.TipsBorad.DAO;

import com.TipsBorad.bean.message;
import com.TipsBorad.common.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class messageDAO {
    public messageDAO(){

    }

    public List<message> getMessages(int page, int size){
        Connection conn = ConnectionUtil.getConnection();

        String sql;//从第m条开始取出n条
        sql = "select * from message order by create_time desc limit ?,?";

        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<message> mesg = new ArrayList<>();

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1,(page - 1 )* size);
            stmt.setInt(2,size);
            rs = stmt.executeQuery();

            while(rs.next()){
                mesg.add(new message(
                        rs.getLong("id"),
                        rs.getLong("user_id"),
                        rs.getString("username"),
                        rs.getString("title"),
                        rs.getString("content"),
                        rs.getTimestamp("create_time")));
            }
//            System.out.println("finished");
        } catch (SQLException e) {
            System.out.println("sql语句解析错误1");
            e.printStackTrace();
        }finally {
            ConnectionUtil.release(rs,stmt,conn);
        }
        return mesg;
    }

    public int countMessage(){
        Connection conn = ConnectionUtil.getConnection();
        String sql;
        sql = "select count(*) t_otal from message";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                   return rs.getInt( "t_otal");
            }
        } catch (SQLException e) {
            System.out.println("sql语句解析错误2");
            e.printStackTrace();
        }finally {
            ConnectionUtil.release(rs,stmt,conn);
        }

        return 0;
    }
}
