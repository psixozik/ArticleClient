package org.example.article.client.service.dbservice;

import lombok.extern.slf4j.Slf4j;
import org.example.article.client.model.NYTArticleDBModel;
import org.example.article.client.model.NYTArticleResponse;
import org.example.article.client.model.RegModelDTO;
import org.example.article.client.repository.ArticlesRepository;
import org.example.article.client.restclient.NYRest.NYTRestClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.ref.WeakReference;
import java.util.List;

@Slf4j
@Service
public class ArticleDBImpl implements ArticleDBService {

    private final NYTRestClientService nytRestClientService;
    private final ArticlesRepository articlesRepository;

    @Autowired
    public ArticleDBImpl(NYTRestClientService nytRestClientService,
                         ArticlesRepository articlesRepository) {
        this.nytRestClientService = nytRestClientService;
        this.articlesRepository = articlesRepository;
    }

    @Override
    public void saveArticleToDB(RegModelDTO clientModel) {
        if(articlesRepository.findByDate(clientModel.getBirthDate()) == null) {
            List<NYTArticleResponse.Doc> articles = nytRestClientService.getArticlesByDateNYT(clientModel.getBirthDate());
            WeakReference<NYTArticleDBModel> dbModel = new WeakReference<>(new NYTArticleDBModel());
            dbModel.get().setDate(clientModel.getBirthDate());
            dbModel.get().setListOfArticles(articles);
            articlesRepository.save(dbModel.get());
            System.gc();
        } else
            log.error("Запись с датой: " + clientModel.getBirthDate() + " уже существует");
    }
}
