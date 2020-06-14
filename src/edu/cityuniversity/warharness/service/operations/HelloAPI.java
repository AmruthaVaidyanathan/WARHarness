package edu.cityuniversity.warharness.service.operations;

import edu.cityuniversity.warharness.service.backend.Backend;
import edu.cityuniversity.warharness.service.backend.HelloBackend;

/**
 * @author rajarar
 */
public class HelloAPI implements API {

    @Override
    public Backend backend() {
        return new HelloBackend();
    }

}
