package org.yeasheng.search.component;

import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;
import org.yeasheng.common.pojo.Product;
import org.yeasheng.common.service.ProductService;
import org.yeasheng.search.pojo.ProductEs;
import org.yeasheng.search.repository.ProductEsRepository;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @author yansh
 * @version 2021/4/20
 **/
@Component
@Log4j2
public class ProductConsumer {

    @Resource
    private ProductService productService;

    @Resource
    private ProductEsRepository productEsRepository;

    private static final String TOPIC_NAME = "product";
    private static final String GROUP_NAME = "group1";


    @KafkaListener(topics = TOPIC_NAME, groupId = GROUP_NAME)
    public void productListener(ConsumerRecord<?, ?> record, Acknowledgment ack, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        Optional<?> value = Optional.ofNullable(record.value());
        if (value.isPresent()) {
            String productId = value.get().toString();
            log.info("从Kafka获取到的商品ID为：" + productId);

            ack.acknowledge();

            Product product = productService.queryById(Integer.valueOf(productId));
            log.info("从数据库获取的商品信息为：" + product.toString());
            ProductEs proEs = new ProductEs(product.getId(), product.getName(), product.getGoodDesc(), product.getPrice());
            productEsRepository.save(proEs);
            log.info("商品信息保存到ES中成功");
        }

    }

}
