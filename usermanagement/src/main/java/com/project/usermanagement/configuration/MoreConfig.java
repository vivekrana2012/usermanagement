package com.project.usermanagement.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

@Configuration
public class MoreConfig {

    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/usermanagement");
        driverManagerDataSource.setUsername("myuser");
        driverManagerDataSource.setPassword("mypassword");
        return driverManagerDataSource;
    }

    @Bean
    public UserDetailsService userDetailsService(){
        JdbcDaoImpl jdbcImpl = new JdbcDaoImpl();
        jdbcImpl.setDataSource(dataSource());
        jdbcImpl.setUsersByUsernameQuery("select username, password from user where username = ?");
        jdbcImpl.setAuthoritiesByUsernameQuery("select u.username, r.name from user u inner join user_role ur on(u.id=ur.user_id) inner join role r on(ur.role_id=r.id) where u.username= ?");
        return jdbcImpl;
    }
}
