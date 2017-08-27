package net.quantiful.dataprocess.init;

import java.sql.*;

/**
 * Created by rogersong on 25/08/17.
 */
public class TestHive {
    private static String driverName = "org.apache.hive.jdbc.HiveDriver";//jdbc驱动路径
    private static String url = "jdbc:hive2://ec2-54-252-224-98.ap-southeast-2.compute.amazonaws.com:10000/fb";//hive库地址+库名
    private static String user = "hadoop";//用户名
    private static String sql = "";
    private static String password = "";
    private static ResultSet res;

    public static void runit() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = getConn();
            System.out.println(conn);
            stmt = conn.createStatement();
            String tableName="tab_name";//hive表名
            sql = "select * from " + "t1";
            System.out.println("Running:" + sql);
            res = stmt.executeQuery(sql);
            System.out.println("执行 select * query 运行结果:");
            while (res.next()) {
                System.out.println(res.getInt(2) + "\t" + res.getString(1));
            }
            stmt.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            try {
                if (conn != null) {
                    conn.close();
                    conn = null;
                }
                if (stmt != null) {
                    stmt.close();
                    stmt = null;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            stmt.close();
        }
    }

    private static Connection getConn() throws ClassNotFoundException, SQLException {
        Class.forName(driverName);

        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }
}
