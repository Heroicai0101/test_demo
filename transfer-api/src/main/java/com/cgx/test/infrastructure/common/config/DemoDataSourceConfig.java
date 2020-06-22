package com.cgx.test.infrastructure.common.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@MapperScan(basePackages = "com.cgx.test.infrastructure.persistence.demo.mapper",
        sqlSessionTemplateRef = "demoSqlSessionTemplate")
public class DemoDataSourceConfig extends BaseDruidDataSource {

    @Value("${demo.datasource.url}")
    private String url;

    @Value("${demo.datasource.username}")
    private String username;

    @Value("${demo.datasource.password}")
    private String password;

    @Resource
    private PageHelper pageHelper;

    @Bean(name = "demoDataSource")
    public DataSource demoDataSource() throws SQLException {
        DruidDataSource dataSource = createDataSource(url, username, password);
        dataSource.setFilters("stat,wall,logback");
        dataSource.setConnectionProperties("druid.stat.mergeSql=true;druid.stat.slowSqlMillis=5000");
        return dataSource;
    }

    @Bean(name = "demoSqlSessionFactory")
    public SqlSessionFactory demoSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(demoDataSource());
        bean.setPlugins(new Interceptor[]{pageHelper});
        bean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:mapper/demo/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "demoSqlSessionTemplate")
    public SqlSessionTemplate demoSqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(demoSqlSessionFactory());
    }

    @Bean(name = "demoDataSourceTransactionManager")
    public DataSourceTransactionManager demoDataSourceTransactionManager() throws SQLException {
        return new DataSourceTransactionManager(demoDataSource());
    }

}
