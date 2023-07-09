package com.zn.portfolio.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.retry.support.RetryTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;

import static com.zn.portfolio.utils.Constants.*;

@Configuration
public class DatabaseConfiguration {

    @Autowired
    private RetryTemplate retryTemplate;

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(DATA_SOURCE_DRIVER);
        dataSource.setUrl(DATA_SOURCE_URL);
        dataSource.setUsername(DATA_SOURCE_USER);
        dataSource.setPassword(DATA_SOURCE_PASSWORD);

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
