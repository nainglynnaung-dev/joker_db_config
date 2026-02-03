package com.jokerdb.mm.custom;

import com.jokerdb.mm.custom.JokerConfigHolder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import javax.sql.DataSource;

@Configuration
public class JokerDbAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public DataSource dataSource() {

        if (JokerConfigHolder.TYPE == null) {
            throw new IllegalStateException(
                    "JokerConfigHolder.TYPE is null! Did you forget to add @EnableJokerDb in your main application?"
            );
        }
        String url = buildJdbcUrl();
        String driver = getDriver();

        return DataSourceBuilder.create()
                .url(url)
                .username(JokerConfigHolder.USERNAME)
                .password(JokerConfigHolder.PASSWORD)
                .driverClassName(driver)
                .build();
    }

    private String buildJdbcUrl() {
        return switch (JokerConfigHolder.TYPE) {
            case POSTGRES -> "jdbc:postgresql://localhost:5432/" + JokerConfigHolder.NAME;
            case MYSQL -> "jdbc:mysql://localhost:3306/" + JokerConfigHolder.NAME;
            case MSSQL -> "jdbc:sqlserver://localhost:1433;databaseName=" + JokerConfigHolder.NAME;
            case ORACLE -> "jdbc:oracle:thin:@localhost:1521:" + JokerConfigHolder.NAME;
            case H2 -> "jdbc:h2:mem:" + JokerConfigHolder.NAME;
        };
    }

    private String getDriver() {
        return switch (JokerConfigHolder.TYPE) {
            case POSTGRES -> "org.postgresql.Driver";
            case MYSQL -> "com.mysql.cj.jdbc.Driver";
            case MSSQL -> "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            case ORACLE -> "oracle.jdbc.OracleDriver";
            case H2 -> "org.h2.Driver";
        };
    }
}
