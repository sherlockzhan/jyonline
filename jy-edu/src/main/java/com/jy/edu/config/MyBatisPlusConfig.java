package com.jy.edu.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author 炘爷
 * @create 2020-02-22 2:09
 */
@Configuration
@MapperScan("com.jy.edu.mapper")
@EnableTransactionManagement
public class MyBatisPlusConfig {

    @Bean
    public ISqlInjector iSqlInjector() {
        return new LogicSqlInjector();
    }
}
