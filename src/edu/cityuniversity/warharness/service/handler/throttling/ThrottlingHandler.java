package edu.cityuniversity.warharness.service.handler.throttling;

import com.google.common.util.concurrent.RateLimiter;
import edu.cityuniversity.warharness.service.entity.Request;
import edu.cityuniversity.warharness.service.handler.RequestHandler;
import edu.cityuniversity.warharness.service.entity.Response;

/**
 *
 */
public class ThrottlingHandler implements RequestHandler<Request, Response> {

    private static final RateLimiter LIMITER = RateLimiter.create(1);
    private final RequestHandler delegate;

    public ThrottlingHandler(RequestHandler delegate) {
        this.delegate = delegate;
    }

    @Override
    public Response handle(Request request) {
        if (LIMITER.tryAcquire(1)) {
            return delegate.handle(request);
        }

        return ErrorResponses.throttledResponse();
    }
}
