package edu.cityuniversity.warharness.service.handler.authentication;

import edu.cityuniversity.warharness.service.WARHarnessHeaders;
import edu.cityuniversity.warharness.service.entity.Request;
import edu.cityuniversity.warharness.service.entity.Response;
import edu.cityuniversity.warharness.service.handler.RequestHandler;
import edu.cityuniversity.warharness.service.handler.ErrorResponses;

import java.util.Optional;

/**
 *
 */
public class AuthenticationHandler implements RequestHandler<Request, Response> {

    private final RequestHandler delegate;

    public AuthenticationHandler(RequestHandler delegate) {
        this.delegate = delegate;
    }

    @Override
    public Response handle(Request request) {
        Optional<String> client = request.header(WARHarnessHeaders.X_CITYU_client);

        boolean isAuthenticated = client
                .map(AuthenticatedEntities::isAuthenticated)
                .orElse(false);

        if (isAuthenticated) {
            return this.delegate.handle(request);
        }

        return ErrorResponses.notAuthenticated();
    }
}
