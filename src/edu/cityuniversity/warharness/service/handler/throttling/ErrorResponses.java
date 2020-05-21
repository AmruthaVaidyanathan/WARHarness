package edu.cityuniversity.warharness.service.handler.throttling;

import edu.cityuniversity.warharness.service.entity.Response;

/**
 *
 */
public class ErrorResponses {

    public static Response throttledResponse() {
        return Response.builder()
                .withContentType("application/json")
                .withStatusCode(429)
                .withPayload("{\"message\" : \"Throttled by rate limiter\"}")
                .build();
    }

    public static Response notAuthenticated() {
        return Response.builder()
                .withContentType("application/json")
                .withStatusCode(403)
                .withPayload("{\"message\" : \"Unrecognized caller\"}")
                .build();
    }
}
