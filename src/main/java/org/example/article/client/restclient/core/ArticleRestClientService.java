package org.example.article.client.restclient.core;

import org.example.article.client.model.NYTArticleResponse;

import java.time.LocalDate;
import java.util.Date;

public interface ArticleRestClientService {

    NYTArticleResponse getArticlesByDateNYT(LocalDate date);
}
