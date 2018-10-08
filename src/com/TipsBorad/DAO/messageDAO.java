package com.TipsBorad.DAO;

import com.TipsBorad.bean.User;
import com.TipsBorad.bean.message;
import com.TipsBorad.common.ConnectionUtil;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    public boolean upDateMessage(String title, String content, User user){
        Connection conn = ConnectionUtil.getConnection();
        PreparedStatement stmt = null;
        String sql = null;
        String date = null;
        sql = "insert into message(?,?,?,?,?,?)";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1,user.getId());
            stmt.setLong(2,user.getId());
            stmt.setString(3,user.getUsername());
            stmt.setString(4,title);
            stmt.setString(5,content);
            try {
                stmt.setTimestamp(6,);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            stmt.execute();

        } catch (SQLException e) {
            System.out.println("Add Message Fail!");
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
