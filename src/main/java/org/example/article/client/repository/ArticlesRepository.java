package org.example.article.client.repository;

import org.example.article.client.model.NYTArticleDBModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArticlesRepository extends MongoRepository<NYTArticleDBModel, String> {
    NYTArticleDBModel findByDate(String date);
}
