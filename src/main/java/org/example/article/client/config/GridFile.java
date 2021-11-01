package org.example.article.client.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

@Configuration
public class GridFile {

        private final MappingMongoConverter mongoConverter;

        @Autowired
        public GridFile(MappingMongoConverter mongoConverter) {
                this.mongoConverter = mongoConverter;
        }

        @Bean
        public GridFsTemplate gridFsTemplate(@Autowired MongoDatabaseFactory mongoDatabaseFactory) {
            return new GridFsTemplate(mongoDatabaseFactory, mongoConverter);
        }
}
