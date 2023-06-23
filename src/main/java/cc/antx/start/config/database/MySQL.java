package cc.antx.start.config.database;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author zhong
 * @date 2023-03-05 16:45
 */


@Component
@ConfigurationProperties(prefix = "mysql")
public class MySQL {
    /**
     * MySQL 驱动
     */
    private String jdbc_driver;
    /**
     * MySQL DB_URL
     */
    private String db_url;
    /**
     * MySQL 用户名
     */
    private String user;
    /**
     * MySQL 密码
     */
    private String password;

}
