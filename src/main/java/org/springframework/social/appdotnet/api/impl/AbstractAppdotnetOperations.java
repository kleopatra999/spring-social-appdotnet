package org.springframework.social.appdotnet.api.impl;

import org.springframework.social.appdotnet.api.data.ADNPaging;
import org.springframework.social.appdotnet.api.data.ADNResponseMeta;
import org.springframework.social.support.URIBuilder;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * Superclass to all App.net sub-api implementation templates
 *
 * @author Arik Galansky
 */
abstract class AbstractAppdotnetOperations {
    protected static final String VERSION_0 = "0";

    protected final RestTemplate restTemplate;
    protected final String accessToken;
    private final String baseUrl;
    private final String defaultResource;

    public AbstractAppdotnetOperations(String accessToken, RestTemplate restTemplate, String name, String version) {
        this.restTemplate = restTemplate;
        this.accessToken = accessToken;
        this.baseUrl = new StringBuilder().append("https://alpha-api.app.net/stream/")
                .append(version).append("/").toString();
        this.defaultResource = name;
    }

    protected String buildUri(String uri, Map<String, String> params) {
        return buildUri(defaultResource, uri, params);
    }

    protected String buildUri(String resource, String uri, Map<String, String> params) {
        String url = new StringBuilder().append(baseUrl).append(resource).append("/").append(uri).toString();
        URIBuilder builder = URIBuilder.fromUri(url);
        if (accessToken != null) {
            builder = builder.queryParam("access_token", accessToken);
        }
        if (params != null && !params.isEmpty()) {
            for (Map.Entry<String, String> param : params.entrySet()) {
                builder.queryParam(param.getKey(), param.getValue());
            }
        }
        return builder.build().toString();
    }

    protected ADNPaging createPaging(ADNResponseMeta meta) {
        if (meta != null) {
            return new ADNPaging(meta.getMin_id(), meta.getMax_id(), meta.getMore());
        }
        return null;
    }

    protected String buildUri(String uri) {
        return buildUri(uri, null);
    }

    protected String buildUri() {
        return buildUri("");
    }
}
