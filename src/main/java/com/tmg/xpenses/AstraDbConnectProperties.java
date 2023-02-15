package com.tmg.xpenses;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * maps astradb connection values from a "astradb.secret.properties" file.
 */
@Configuration
@PropertySource("classpath:astradb.secret.properties")
public class AstraDbConnectProperties {

    @Value("${astra.db.id}")
    private String astraDbId;

    @Value("${astra.db.username}")
    private String astraDbUsername;

    @Value("${astra.db.password}")
    private String astraDbPassword;

    @Value("${astra.db.token}")
    private String astraDbToken;



    public String getAstraDbId() {
        return astraDbId;
    }

    public String getAstraDbUsername() {
        return astraDbUsername;
    }

    public String getAstraDbPassword() {
        return astraDbPassword;
    }

    public String getAstraDbToken() {
        return astraDbToken;
    }

    public void setAstraDbId(String astraDbId) {
        this.astraDbId = astraDbId;
    }

    public void setAstraDbUsername(String astraDbUsername) {
        this.astraDbUsername = astraDbUsername;
    }

    public void setAstraDbPassword(String astraDbPassword) {
        this.astraDbPassword = astraDbPassword;
    }

    public void setAstraDbToken(String astraDbToken) {
        this.astraDbToken = astraDbToken;
    }

}
