package edu.cityuniversity.warharness.service.handler;

public class HttpRequestHandler implements RequestHandler {

    String message = "This is a message from the handler";
    String response = "{\"message\" : \"" + this.message + "\" }";

    @Override
    public Response handle(Request request) {
        return Response.builder()
                .withContentType("application/json")
                .withPayload(response)
                .build();
    }
}
