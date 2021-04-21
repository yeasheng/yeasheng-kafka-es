package org.yeasheng.search.config;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author yansh
 * @version 2021/4/19
 **/
@MapperScan({"org.yeasheng.*.mapper"})
@Configuration
@EnableTransactionManagement
public class MybatisConfig {

}
