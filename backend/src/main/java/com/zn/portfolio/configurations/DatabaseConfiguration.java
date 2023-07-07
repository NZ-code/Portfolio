package com.zn.portfolio.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.retry.support.RetryTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class DatabaseConfiguration {
    @Autowired
    private RetryTemplate retryTemplate;

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://database:3306/mydatabase");
        dataSource.setUsername("myuser");
        dataSource.setPassword("mypassword");

        try {
            return retryTemplate.execute(context -> {
                // Retryable code block
                dataSource.getConnection();
                return dataSource;
            });
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
