package com.tmg.xpenses.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatasourceConfig {


    @Bean
    public DataSource dataSource(MysqlDbConnectProperties properties){
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();


        return dataSourceBuilder.url(properties.getUrl())
                .driverClassName(properties.getDriverClass())
                .username(properties.getUsername())
                .password(properties.getPassword()).build();

    }
}
