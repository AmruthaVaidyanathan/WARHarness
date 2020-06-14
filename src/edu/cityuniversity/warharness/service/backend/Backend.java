package edu.cityuniversity.warharness.service.backend;

import edu.cityuniversity.warharness.service.entity.Request;
import edu.cityuniversity.warharness.service.entity.Response;

/**
 *
 */
public interface Backend {
    Response serve(Request request);
}
