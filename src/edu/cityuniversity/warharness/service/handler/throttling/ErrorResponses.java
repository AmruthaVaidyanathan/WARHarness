package edu.cityuniversity.warharness.service.handler.throttling;

import edu.cityuniversity.warharness.service.entity.Response;

/**
 *
 */
public class ErrorResponses {

    public static Response notAuthenticated() {
        return Response.builder()
                .withContentType("application/json")
                .withStatusCode(403)
                .withPayload("{\"message\" : \"Unrecognized caller\"}")
                .build();
    }

    public static Response badRequest(final String message) {
        return Response.builder()
                .withContentType("application/json")
                .withStatusCode(400)
                .withPayload("{\"message\" : \"" + message + "\"")
                .build();
    }

    public static Response failure(final String message) {
        return Response.builder()
                .withContentType("application/json")
                .withStatusCode(503)
                .withPayload("{\"message\" : \"" + message + "\"")
                .build();
    }
}
