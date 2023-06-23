package cc.antx.start.server.config.database;


/**
 * 数据库配置类
 */
public class Configuration {
    /**
     * MySQL配置类
     */
    public static class MySQL {

        /**
         * MySQL的驱动
         */
        public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        /**
         * MySQL的DB_URL
         */
        public static final String DB_URL = "jdbc:mysql://localhost:3306/antx?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        /**
         * MySQL的用户名
         */
        public static final String USERNAME = "root";
        /**
         * MySQL的密码
         */
        public static final String PASSWORD = "zhong0911MySQL";
    }
}
