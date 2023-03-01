package com.tmg.xpenses.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * maps mysql connection values from a "mysql.secret.properties" file.
 */
@Configuration
@PropertySource("classpath:mysql.secret.properties")
public class MysqlDbConnectProperties {

    @Value("${expenses.db.username}")
    private String username;

    @Value("${expenses.db.password}")
    private String password;
    @Value("${expenses.db.url}")
    private String url;
    @Value("${expenses.db.driver-class}")
    private String driverClass;



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDriverClass() {
        return driverClass;
    }

    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }
}
