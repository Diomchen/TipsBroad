package com.TipsBorad.DAO;

import com.TipsBorad.bean.User;
import com.TipsBorad.common.ConnectionUtil;

import java.sql.*;

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

    public User getUserById(Long id){
        Connection conn = ConnectionUtil.getConnection();
        String sql = null;
        sql = "select * from user where id = ?";
        PreparedStatement stmt = null;
        User user = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1,id);
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

    public boolean upDate(User user){
        Connection conn = ConnectionUtil.getConnection();
        PreparedStatement stmt = null;
        String sql = "update user set username = ?,password = ?,realname = ?,birth = ?,phone = ?,address = ? where id = ?";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,user.getUsername());
            stmt.setString(2,user.getPassword());
            stmt.setString(3,user.getRealname());
            stmt.setDate(4,new Date(user.getBirth().getTime()));

            stmt.setString(5,user.getPhone());
            stmt.setString(6,user.getAddress());
            stmt.setLong(7,user.getId());
            stmt.execute();
        } catch (SQLException e) {
            System.out.println("wrong in input!");
            e.printStackTrace();
            return false;
        }
        finally {
            ConnectionUtil.release(null,stmt,conn);
        }
        return true;
    }


}
