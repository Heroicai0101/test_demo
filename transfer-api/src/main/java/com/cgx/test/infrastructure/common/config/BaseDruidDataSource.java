package com.cgx.test.infrastructure.common.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;

import java.sql.SQLException;

public abstract class BaseDruidDataSource {

    @Value("${datasource.driverClassName}")
    private String driverClassName;

    @Value("${datasource.maxActive}")
    private int maxActive;

    @Value("${datasource.initialSize}")
    private int initialSize;

    @Value("${datasource.maxWait}")
    private int maxWait;

    @Value("${datasource.minIdle}")
    private int minIdle;

    @Value("${datasource.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;

    @Value("${datasource.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis;

    @Value("${datasource.validationQuery}")
    private String validationQuery;

    @Value("${datasource.testWhileIdle}")
    private boolean testWhileIdle;

    @Value("${datasource.testOnBorrow}")
    private boolean testOnBorrow;

    @Value("${datasource.testOnReturn}")
    private boolean testOnReturn;

    @Value("${datasource.poolPreparedStatements}")
    private boolean poolPreparedStatements;

    @Value("${datasource.filters}")
    private String filters;

    @Value("${datasource.connectionProperties}")
    private String connectionProperties;

    @Value("${datasource.useGlobalDataSourceStat}")
    private boolean useGlobalDataSourceStat;

    public DruidDataSource createDataSource(String url, String username, String password) throws SQLException {
        DruidDataSource dataSource = initDruidDatasource(url, username, password);

        dataSource.setDriverClassName(driverClassName);
        dataSource.setInitialSize(initialSize);
        dataSource.setMinIdle(minIdle);
        dataSource.setMaxActive(maxActive);
        dataSource.setMaxWait(maxWait);
        dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        dataSource.setValidationQuery(validationQuery);
        dataSource.setTestWhileIdle(testWhileIdle);
        dataSource.setTestOnBorrow(testOnBorrow);
        dataSource.setTestOnReturn(testOnReturn);
        dataSource.setPoolPreparedStatements(poolPreparedStatements);
        dataSource.setConnectionProperties(connectionProperties);
        dataSource.setUseGlobalDataSourceStat(useGlobalDataSourceStat);
        dataSource.setFilters(filters);
        return dataSource;
    }

    private DruidDataSource initDruidDatasource(String url, String username, String password) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

}
