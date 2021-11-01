package org.example.article.client.restclient.NYRest;

import lombok.extern.slf4j.Slf4j;
import org.example.article.client.model.NYTArticleResponse;
import org.example.article.client.restclient.core.ArticleRestClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Slf4j
@Service
public class NYResClientImpl implements NYTRestClientService {

    private final ArticleRestClientService articleRestClientService;

    @Autowired
    public NYResClientImpl(ArticleRestClientService articleRestClientService) {
        this.articleRestClientService = articleRestClientService;
    }

    @Override
    public List<NYTArticleResponse.Doc> getArticlesByDateNYT(String date) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate localDate = LocalDate.parse(date, dtf);
        return articleRestClientService.getArticlesByDateNYT(localDate).getResponse().getDocs();
    }
}
