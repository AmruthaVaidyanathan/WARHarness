package edu.cityuniversity.warharness.service.handler;

/**
 * @author rajarar
 */
public interface RequestHandler<T extends Request, R extends Response> {

    R handle(T request);
}
