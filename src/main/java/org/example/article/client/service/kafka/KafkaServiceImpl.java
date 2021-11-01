package org.example.article.client.service.kafka;

import lombok.extern.slf4j.Slf4j;
import org.example.article.client.model.RegModelDTO;
import org.example.article.client.service.dbservice.ArticleDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaServiceImpl {

    private final ArticleDBService articleDBService;

    @Autowired
    public KafkaServiceImpl(ArticleDBService articleDBService) {
        this.articleDBService = articleDBService;
    }

    @KafkaListener(
            topics = "${kafka.topic}",
            containerFactory = "regKafkaListenerContainerFactory"
    )
    public void listenBrokerRegister(RegModelDTO message) {
        log.error("IN");
        articleDBService.saveArticleToDB(message);
        log.error("OUT");
    }
}
