package edu.cityuniversity.warharness.service.entity;

import com.google.common.collect.ImmutableMap;
import edu.cityuniversity.warharness.service.operations.API;

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
    private API operation;

    private Request(final Builder builder) {
        this.queryParams = queryParams(builder.request);
        this.headers = headers(builder.request);
        this.operation = extractOperation(builder.request);
    }

    private API extractOperation(final HttpServletRequest request) {
        return API.of(request.getHeader("Accept"));
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

    public Optional<String> queryValue(String key) {
        return getString(key, queryParams);
    }

    public Optional<String> header(String key) {
        return getString(key, headers);
    }

    public API operation() {
        return operation;
    }

    private static Optional<String> getString(String key, Map<String, String> headers) {
        if (headers.containsKey(key)) {
            return Optional.of(headers.get(key));
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
