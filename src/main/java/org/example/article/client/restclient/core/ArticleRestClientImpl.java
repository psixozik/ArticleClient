package org.example.article.client.restclient.core;

import lombok.extern.slf4j.Slf4j;
import org.example.article.client.model.NYTArticleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Slf4j
@Service
public class ArticleRestClientImpl implements ArticleRestClientService {

    @Value("${api.NY.key}")
    private String apiKeyNYT;

    private final WebClient NYTRest;

    @Autowired
    public ArticleRestClientImpl(@Qualifier("NYArchiveRest") WebClient NYTRest) {
        this.NYTRest = NYTRest;
    }

    public NYTArticleResponse getArticlesByDateNYT(LocalDate date) {
        Mono<NYTArticleResponse> responseSpec = NYTRest.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/archive/v1/{year}/{month}.json")
                        .queryParam("api-key", apiKeyNYT)
                        .build(date.getYear(), date.getMonth().getValue()))
                .accept(MediaType.APPLICATION_JSON)
                .exchangeToMono(response -> response.bodyToMono(NYTArticleResponse.class));
        return responseSpec.block();
    }
}
