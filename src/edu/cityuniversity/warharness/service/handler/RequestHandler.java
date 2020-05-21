package edu.cityuniversity.warharness.service.handler;

import edu.cityuniversity.warharness.service.entity.Request;
import edu.cityuniversity.warharness.service.entity.Response;

/**
 *
 */
public interface RequestHandler<T extends Request, R extends Response> {

    R handle(T request);
}
