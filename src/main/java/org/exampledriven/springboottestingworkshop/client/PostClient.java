package org.exampledriven.springboottestingworkshop.client;

import org.exampledriven.springboottestingworkshop.domain.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by Peter Szanto on 7/2/2017.
 */
@Component
public class PostClient {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final RestTemplate restTemplate;

    public PostClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Value("${post-service.url}")
    private String url;

    public List<Post> readPosts(int userId) {

        logger.debug("Calling " + url + "with " + userId);

        return restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Post>>() {},
                userId
        ).getBody();
    }

}