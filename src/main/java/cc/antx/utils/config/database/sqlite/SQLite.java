package cc.antx.utils.config.database.sqlite;

/**
 * SQLite配置类
 *
 * @author zhong
 * @date 2023-02-07 11:02
 */
public class SQLite {
    /**
     * SQLite JDBC 驱动类
     */
    public static final String JDBC_DRIVER = "org.sqlite.JDBC";
    /**
     * 手机号数据库的DB_URL
     */
    public static final String PHONE_DB_URL = "jdbc:sqlite:src/main/resources/sqlite/phone.db";
    //public static final String PHONE_DB_URL = "jdbc:sqlite::resource:sqlite/phone.db";
}
