package cn.edu;

import oracle.jdbc.OracleDriver;

import java.sql.*;

/**
 * @author LZDWTL
 * @date 2021-06-06 20:00
 */
public class Jdbc {

    public boolean selectUser(String username,String password){
        String sql="select * from users where username=? and password=?";
//        select * from users where username='张三' and password='123';
        Connection conn = null;
        ResultSet rs = null;
        try {
//            组测数据库驱动的两种方法：
            Class.forName("oracle.jdbc.driver.OracleDriver");
//            DriverManager.registerDriver(new OracleDriver());
            conn=DriverManager.getConnection(
                    "jdbc:oracle:thin:@120.77.80.134:1521:orcl", "scott", "tiger");
            PreparedStatement pstm=conn.prepareStatement(sql);
            pstm.setString(1,username);
            pstm.setString(2,password);
            rs=pstm.executeQuery();
            if (rs.next()){
                try {
                    rs.close();
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return true;
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                rs.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
