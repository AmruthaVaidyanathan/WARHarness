package edu.cityuniversity.warharness.service.backend;

import edu.cityuniversity.warharness.service.entity.Request;
import edu.cityuniversity.warharness.service.entity.Response;

/**
 * Provided a Request with body
 */
public class CrawlBackend implements Backend {

    public CrawlBackend() {

    }

    @Override
    public Response serve(final Request request) {
        return Response.builder()
                .withPayload("{\"source\":\"com.warharness.test\"}")
                .withStatusCode(200)
                .withContentType("application/json")
                .build();
    }
}
