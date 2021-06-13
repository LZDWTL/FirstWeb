package cn.edu.dao.impl;

import cn.edu.bean.User;
import cn.edu.dao.IUserDao;
import oracle.jdbc.driver.OracleDriver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author LZDWTL
 * @date 2021-06-07 20:00
 */
public class UserDaoimpl implements IUserDao {
    @Override
    public List<User> viewUser() {
        List<User> userList=new ArrayList<User>();
        Connection conn=null;
        ResultSet rs=null;
        PreparedStatement pstmt=null;
        String sql="select * from users";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
//            DriverManager.registerDriver(new OracleDriver());
            conn=DriverManager.getConnection("jdbc:oracle:thin:@120.77.80.134:1521:orcl","scott","tiger");
            pstmt=conn.prepareStatement(sql);
            rs=pstmt.executeQuery();

            while (rs.next()){
                User user=new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                userList.add(user);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return userList;
    }


    @Override
    public void deleteUser(int id) {
        Connection conn=null;
        PreparedStatement pstmt=null;
        String sql="delete from users where id =?";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
//            DriverManager.registerDriver(new OracleDriver());
            conn=DriverManager.getConnection("jdbc:oracle:thin:@120.77.80.134:1521:orcl","scott","tiger");
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            pstmt.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void updateUser(int id, String username, String password) {
        Connection conn=null;
        String sql="update users set username=? ,password=? where id=?";
        PreparedStatement pstm=null;

        try {
            DriverManager.registerDriver(new OracleDriver());
            conn=DriverManager.getConnection("jdbc:oracle:thin:@120.77.80.134:1521:orcl","scott","tiger");
            pstm=conn.prepareStatement(sql);
            pstm.setInt(3,id);
            pstm.setString(1,username);
            pstm.setString(2,password);
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                pstm.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void addUser(int id, String username, String password) {
        Connection conn=null;
        String sql="insert into users values(?,?,?)";
        PreparedStatement pstmt=null;

        try {
            DriverManager.registerDriver(new OracleDriver());
            conn=DriverManager.getConnection("jdbc:oracle:thin:@120.77.80.134:1521:orcl","scott","tiger");
            pstmt=conn.prepareStatement(sql);

            pstmt.setInt(1,id);
            pstmt.setString(2,username);
            pstmt.setString(3,password);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
