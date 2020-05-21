package edu.cityuniversity.warharness.service.handler;

import edu.cityuniversity.warharness.service.handler.authentication.AuthenticationHandler;
import edu.cityuniversity.warharness.service.handler.request.HttpRequestHandler;
import edu.cityuniversity.warharness.service.handler.throttling.ThrottlingHandler;

/**
 *
 */
public class HandlerChain {

    public static RequestHandler create() {
        return new AuthenticationHandler(
                new ThrottlingHandler(
                        new HttpRequestHandler()));
    }

}
