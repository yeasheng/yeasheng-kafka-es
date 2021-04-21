package org.yeasheng.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * @author yansh
 * @version 2021/4/20
 **/
@SpringBootApplication
@EnableElasticsearchRepositories
public class ProductSearchApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductSearchApplication.class, args);
    }
}
