//package com.ipa.openapi.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Component;
//
//import javax.sql.DataSource;
//import java.sql.Connection;
//import java.sql.Statement;
//
//@Component
//public class PostgreSQLConfig implements ApplicationRunner {
//    private final DataSource dataSource;
//    private final JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    public PostgreSQLConfig(DataSource dataSource,
//                            JdbcTemplate jdbcTemplate) {
//        this.dataSource = dataSource;
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        try (Connection connection = dataSource.getConnection()){
//            System.out.println("dataSource Class > " + dataSource.getClass());
//            System.out.println("URL > " + connection.getMetaData().getURL());
//            System.out.println("userName > " + connection.getMetaData().getUserName());
//
//            Statement statement = connection.createStatement();
//            String sql = "CREATE TABLE client (NO INTEGER NOT NULL, nickname VARCHAR(255), PRIMARY KEY (NO))";
//            statement.executeUpdate(sql);
//        }
//
//        jdbcTemplate.execute("INSERT INTO client VALUES (1, 'jinu')");
//    }
//
//}
