package edu.cityuniversity.warharness.service.handler.request;

import edu.cityuniversity.warharness.service.entity.Request;
import edu.cityuniversity.warharness.service.entity.Response;
import edu.cityuniversity.warharness.service.handler.RequestHandler;

public class HttpRequestHandler implements RequestHandler {

    @Override
    public Response handle(Request request) {
        final String message = request.queryValue("user")
                .map(user -> "This is a message from " + user)
                .orElse("No user found. Hello from the service.");

        final String response = "{\"message\" : \"" + message + "\" }";
        return Response.builder()
                .withContentType("application/json")
                .withPayload(response)
                .build();
    }
}
