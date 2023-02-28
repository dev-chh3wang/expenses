package com.tmg.xpenses.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
public class DatasourceConfig {


    @Bean
    @Profile("!test")
    public DataSource dataSource(MysqlDbConnectProperties properties){
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        return dataSourceBuilder.url(properties.getUrl())
                .driverClassName(properties.getDriverClass())
                .username(properties.getUsername())
                .password(properties.getPassword()).build();

    }

    @Bean
    @Profile("test")
    public DataSource testDatasource(){

        return DataSourceBuilder.create()
                .url("jdbc:h2:mem:testdb")
                .username("sa")
                .password("sa")
                .driverClassName("org.h2.Driver").build();
    }
}
