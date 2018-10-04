package com.TipsBorad.common;

import javax.xml.transform.Result;
import java.sql.*;

public final class ConnectionUtil {
    private ConnectionUtil(){}

    private static String url = "jdbc:mysql://localhost:3306/TipsBoard";
    private static String user = "root";
    private static String password = "csh66666";


    static{
        try {
            Class.forName("com.mysql.jdbc");
        } catch (ClassNotFoundException e) {
            System.out.println("找不到数据库驱动");
            e.printStackTrace();
        }
    }

    public static Connection getConnectio(){
        try {
            return DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            System.out.println("创建数据库连接失败");
            e.printStackTrace();
        }
        return null;
    }

    public static void release(ResultSet rs, Statement st, Connection conn){
        try {
            if(rs != null){
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            try {
                    if(st != null){
                    st.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            finally {
                try {
                    if(conn != null){
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                finally {
                }
            }
        }
    }


}
