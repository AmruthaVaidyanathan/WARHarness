package edu.cityuniversity.warharness.service.handler.request;

import edu.cityuniversity.warharness.service.entity.Request;
import edu.cityuniversity.warharness.service.handler.RequestHandler;
import edu.cityuniversity.warharness.service.entity.Response;

public class HttpRequestHandler implements RequestHandler {

    String message = "This is a message from the Request Handler";
    String response = "{\"message\" : \"" + this.message + "\" }";

    @Override
    public Response handle(Request request) {
        return Response.builder()
                .withContentType("application/json")
                .withPayload(response)
                .build();
    }
}
