package com.example.jdbi.configuration;

import com.example.jdbi.model.Developer;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.mapper.reflect.ConstructorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

import javax.sql.DataSource;

@Configuration
public class PersistenceConfiguration {

    @Autowired
    private DataSource dataSource;

    @Bean
    public Jdbi jdbi(DataSource dataSource) {
        TransactionAwareDataSourceProxy dataSourceProxy = new TransactionAwareDataSourceProxy(dataSource);
        Jdbi jdbi = Jdbi.create(dataSourceProxy);
        jdbi.installPlugins();
        jdbi.registerRowMapper(Developer.class, ConstructorMapper.of(Developer.class));

        return jdbi;
    }
}