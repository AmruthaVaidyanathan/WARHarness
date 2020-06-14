package edu.cityuniversity.warharness.service.operations;

import edu.cityuniversity.warharness.service.backend.Backend;
import edu.cityuniversity.warharness.service.backend.CrawlBackend;

/**
 * @author rajarar
 */
public class CrawlAPI implements API {

    @Override
    public Backend backend() {
        return new CrawlBackend();
    }

}
