package com.myapp.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:database.properties")
public class DatabaseConfig {

    @Value("${db.host}")
    private String url;
    @Value("${db.login}")
    private String userName;
    @Value("${db.password}")
    private String password;


    @Bean
    public JdbcTemplate jdbcTemplate() {

        return new JdbcTemplate(dataSource());
    }

    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource(url, userName, password);
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");

        return dataSource;
    }


}
