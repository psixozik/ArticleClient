package org.example.article.client.restclient.NYRest;

import org.example.article.client.model.NYTArticleResponse;

import java.util.List;

public interface NYTRestClientService {

    List<NYTArticleResponse.Doc> getArticlesByDateNYT(String date);
}
