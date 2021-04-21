package org.yeasheng.product.service.impl;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.yeasheng.common.mapper.ProductMapper;
import org.yeasheng.common.pojo.Product;
import org.yeasheng.common.service.ProductService;

import javax.annotation.Resource;


/**
 * @author yansh
 * @version 2021/4/17
 **/
@Log4j2
@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductMapper productMapper;

    @Resource
    KafkaTemplate<String, String> kafkaTemplate;

    public static final String TOPIC_NAME = "product";

    @Override
    public Product queryById(Integer id) {
        return productMapper.selectById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long insert(Product product) {
        int result = productMapper.insert(product);
        if (result > 0) {
            ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(TOPIC_NAME, product.getId().toString());
            future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
                @Override
                public void onFailure(Throwable throwable) {
                    log.error(TOPIC_NAME + "-生产者发送消息失败：" + throwable.getMessage());
                }

                @Override
                public void onSuccess(SendResult<String, String> stringStringSendResult) {
                    log.info(TOPIC_NAME + "-生产者发送消息成功：" + stringStringSendResult.toString());
                }
            });
            return Long.valueOf(product.getId());
        } else {
            return -1L;
        }

    }
}
