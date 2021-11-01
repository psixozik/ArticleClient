package org.example.article.client.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "articles")
public class NYTArticleDBModel {

    @Id
    private String id;
    @Indexed(unique = true)
    private String date;
    private List<NYTArticleResponse.Doc> listOfArticles;
}
