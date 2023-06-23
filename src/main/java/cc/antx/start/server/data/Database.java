package cc.antx.start.server.data;

import cc.antx.start.server.config.database.Configuration;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;


/**
 * @author zhong
 * @date 2023-03-04 11:45
 */
public class Database {

    /**
     * 执行SQL语句操作并返回查询结果
     *
     * @param sql SQL语句
     * @param res 要查询的列名
     * @return 查询结果
     */
    public static Object executeQuery(String sql, String res) {
        Connection conn = null;
        Statement stmt = null;
        Object result = null;
        try {
            Class.forName(Configuration.MySQL.JDBC_DRIVER);
            conn = DriverManager.getConnection(Configuration.MySQL.DB_URL, Configuration.MySQL.USERNAME, Configuration.MySQL.PASSWORD);
            stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            String[] resAndType = res.split(":");
            String column = resAndType[0].trim();
            String type = resAndType[1].trim();
            while (resultSet.next()) {
                switch (type) {
                    case "string" -> result = resultSet.getString(column);
                    case "boolean" -> result = resultSet.getBoolean(column);
                    case "int" -> result = resultSet.getInt(column);
                    case "date", "datetime" -> result = resultSet.getDate(column);
                }
            }
            resultSet.close();
            stmt.close();
            conn.close();
        } catch (SQLException | ClassNotFoundException ignored) {
        } catch (NullPointerException nullPointerException) {
            result = null;
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException ignored) {
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return result;
    }


    /**
     * 执行SQl语句
     *
     * @param sql SQl语句
     */
    public static boolean executeSql(String sql) {
        Connection conn = null;
        Statement stmt = null;
        boolean result;
        try {
            Class.forName(Configuration.MySQL.JDBC_DRIVER);
            conn = DriverManager.getConnection(Configuration.MySQL.DB_URL, Configuration.MySQL.USERNAME, Configuration.MySQL.PASSWORD);
            stmt = conn.createStatement();
            stmt.execute(sql);
            stmt.close();
            conn.close();
            result = true;
        } catch (SQLException | ClassNotFoundException ignored) {
            result = false;
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException ignored) {
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return result;
    }
}
