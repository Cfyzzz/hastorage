package ru.nedovizin.config;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class HastorageDSLContext {

    @Autowired
    private JdbcConnections connections;

    @Bean
    public DSLContext dsl() {
        return DSL.using(connections.getUrl(), connections.getUsername(), connections.getPassword());
    }

}
