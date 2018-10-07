package com.TipsBorad.DAO;

import com.TipsBorad.bean.User;
import com.TipsBorad.common.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    public UserDAO(){

    }

    public User getUser(String username,String password){
        Connection conn = ConnectionUtil.getConnection();
        String sql = null;
        sql = "select * from user where username = ? and password = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        User user = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,username);
            stmt.setString(2,password);
            rs = stmt.executeQuery();
            while(rs.next()){
                user = new User(rs.getLong("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("realname"),
                        rs.getTimestamp("birth"),
                        rs.getString("phone"),
                        rs.getString("address"));
            }
        } catch (SQLException e) {
            System.out.println("error:select the user wrong!");
            e.printStackTrace();
        }
        finally {
            return user;
        }

    }


}
