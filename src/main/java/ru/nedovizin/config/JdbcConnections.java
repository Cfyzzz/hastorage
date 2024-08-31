package ru.nedovizin.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
@Data
public class JdbcConnections {

    private String url;
    private String username;
    private String password;

    public String getUrl() {
        return "jdbc:postgresql://localhost:5454/hastorage";
    }

    public String getUsername() {
        return "sanya";
    }

    public String getPassword() {
        return "passWd1984!";
    }
}

