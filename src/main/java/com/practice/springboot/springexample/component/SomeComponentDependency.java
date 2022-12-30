package com.practice.springboot.springexample.component;

import javax.sql.DataSource;
import java.sql.SQLException;

public interface SomeComponentDependency {

    public void SomeComponent(DataSource dataSource) throws SQLException;
}
