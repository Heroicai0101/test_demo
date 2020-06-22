package com.cgx.test.infrastructure.common.config;

import com.github.pagehelper.PageHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class PageHelperConfig {

    /**
     * 分页插件
     */
    @Bean
    public PageHelper pageHelper() {
        PageHelper pageHelper = new PageHelper();
        Properties props = new Properties();
        props.setProperty("reasonable", "false");
        props.setProperty("supportMethodsArguments", "false");
        props.setProperty("params", "count=countSql");
        pageHelper.setProperties(props);
        return pageHelper;
    }

}
