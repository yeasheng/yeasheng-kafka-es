package org.yeasheng.search.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
import org.yeasheng.search.pojo.ProductEs;

/**
 * @author yansh
 * @version 2021/4/19
 **/
@Repository
public interface ProductEsRepository extends ElasticsearchRepository<ProductEs,Integer> {

}
