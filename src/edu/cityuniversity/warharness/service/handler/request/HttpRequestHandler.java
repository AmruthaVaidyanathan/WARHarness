package edu.cityuniversity.warharness.service.handler.request;

import edu.cityuniversity.warharness.service.backend.Backend;
import edu.cityuniversity.warharness.service.context.ServiceContext;
import edu.cityuniversity.warharness.service.entity.Request;
import edu.cityuniversity.warharness.service.entity.Response;
import edu.cityuniversity.warharness.service.handler.RequestHandler;

public class HttpRequestHandler implements RequestHandler {

    private final ServiceContext context;

    public HttpRequestHandler(ServiceContext context) {
        this.context = context;
    }

    @Override
    public Response handle(Request request) {
        Backend backend = request.operation().backend();
        return backend.serve(request);
    }
}
