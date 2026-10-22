package com.example.tasktracker.dbConfiguration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.autoconfigure.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class Oracle_Configuration {
    @Bean
    @ConfigurationProperties(prefix ="spring.datasource.oracle")
    public DataSourceProperties getOracleDsp(){
        return new DataSourceProperties();
    }
    @Bean
    public DataSource getOracleDs(@Qualifier("getOracleDsp") DataSourceProperties dataSourceProperties){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(dataSourceProperties.getUrl());
        dataSource.setUsername(dataSourceProperties.getUsername());
        dataSource.setPassword(dataSourceProperties.getPassword());
        dataSource.setDriverClassName(dataSourceProperties.getDriverClassName());
        return dataSource;
    }
    @Bean
    public JpaVendorAdapter getOracleJva(){
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setGenerateDdl(true);
        jpaVendorAdapter.setShowSql(true);
        return  jpaVendorAdapter;
    }
    @Bean
    public LocalContainerEntityManagerFactoryBean getLocalEntityMfb (@Qualifier("getOracleDs") DataSource dataSource,@Qualifier("getOracleJva")JpaVendorAdapter jpaVendorAdapter){
        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        localContainerEntityManagerFactoryBean.setDataSource(dataSource);
        localContainerEntityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        localContainerEntityManagerFactoryBean.setPackagesToScan("com.example.tasktracker.oracle.repository");
        return localContainerEntityManagerFactoryBean;
    }
    @Bean
    public PlatformTransactionManager getTM(@Qualifier("getLocalEntityMfb") LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean){
        assert  localContainerEntityManagerFactoryBean.getObject()!=null;

        return new JpaTransactionManager(localContainerEntityManagerFactoryBean.getObject());
    }






}
