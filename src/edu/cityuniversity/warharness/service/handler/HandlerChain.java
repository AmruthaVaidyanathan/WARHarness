package edu.cityuniversity.warharness.service.handler;

import edu.cityuniversity.warharness.service.handler.request.HttpRequestHandler;
import edu.cityuniversity.warharness.service.handler.throttling.ThrottlingHandler;

/**
 *
 */
public class HandlerChain {

    public static RequestHandler create() {
        return new ThrottlingHandler(
                new HttpRequestHandler());
    }

}
