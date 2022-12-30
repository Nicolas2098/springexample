package com.practice.springboot.springexample.component;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;


import javax.sql.DataSource;
import java.sql.SQLException;

@Component
public class SomeComponent implements SomeComponentDependency {
    private final Log LOGGER = LogFactory.getLog(SomeComponent.class);


    public void SomeComponent(DataSource dataSource) throws SQLException {
        if (dataSource.getConnection().isValid(1000))
            LOGGER.info("Database connection valid ");
        else
            LOGGER.info("Database connection fail ");
    }
}
