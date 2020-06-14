package edu.cityuniversity.warharness.service.handler;

import edu.cityuniversity.warharness.service.context.ServiceContext;
import edu.cityuniversity.warharness.service.handler.authentication.AuthenticationHandler;
import edu.cityuniversity.warharness.service.handler.request.HttpRequestHandler;

/**
 *
 */
public class HandlerChain {

    public static RequestHandler create(final ServiceContext context) {
        return new AuthenticationHandler(
                    new HttpRequestHandler(context));
    }

}
