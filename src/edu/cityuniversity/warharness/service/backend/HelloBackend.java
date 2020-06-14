package edu.cityuniversity.warharness.service.backend;

import edu.cityuniversity.warharness.service.entity.Request;
import edu.cityuniversity.warharness.service.entity.Response;

/**
 * @author rajarar
 */
public class HelloBackend implements Backend {

    @Override
    public Response serve(final Request request) {
        final String message = request.queryValue("user")
                .map(user -> "Hello from " + user)
                .orElse("No user found. Hello from the service.");

        final String response = "{\"message\" : \"" + message + "\" }";
        return Response.builder()
                .withContentType("application/json")
                .withPayload(response)
                .build();
    }
}
