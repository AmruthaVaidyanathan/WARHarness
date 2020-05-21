package edu.cityuniversity.warharness.service.entity;

import com.google.common.collect.ImmutableMap;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Map;
import java.util.Optional;

/**
 *
 */
public class Request {

    private Map<String, String> queryParams;
    private Map<String, String> headers;

    private Request(final Builder builder) {
        this.queryParams = queryParams(builder.request);
        this.headers = headers(builder.request);
    }

    private static Map<String, String> headers(final HttpServletRequest request) {
        final ImmutableMap.Builder<String, String> headersBuilder = ImmutableMap.builder();

        final Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            headersBuilder.put(headerName, headerValue);
        }

        return headersBuilder.build();
    }

    private static Map<String, String> queryParams(final HttpServletRequest request) {
        final ImmutableMap.Builder<String, String> queryParamBuilder = ImmutableMap.builder();
        if (request.getQueryString() != null) {
            final String[] queries = request.getQueryString().split("&");
            for (String query : queries) {
                String[] queryParts = query.split("=");
                String queryKey = queryParts[0];
                String queryValue = (queryParts.length > 1) ? queryParts[1] : "";
                queryParamBuilder.put(queryKey, queryValue);
            }
        }

        return queryParamBuilder.build();
    }

    public Map<String, String> headers() {
        return this.headers;
    }

    public Map<String, String> queryParams() {
        return this.queryParams;
    }

    public Optional<String> queryValue(String key) {
        if (queryParams.containsKey(key)) {
            return Optional.of(queryParams.get(key));
        }

        return Optional.empty();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        HttpServletRequest request;

        public Builder withServletRequest(HttpServletRequest request) {
            this.request = request;
            return this;
        }

        public Request build() {
            return new Request(this);
        }
    }
}
