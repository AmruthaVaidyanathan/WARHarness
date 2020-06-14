package edu.cityuniversity.warharness.service.operations;

import edu.cityuniversity.warharness.service.backend.Backend;

/**
 * @author rajarar
 */
public interface API {

    static API of(final String acceptHeader) {
        return acceptHeader.equals(APIs.CRAWL_API.entityName())
                ? APIs.CRAWL_API
                : APIs.HELLO_API;
    }

    default String name() {
        return this.getClass().getSimpleName();
    }

    default String version() {
        return "v" + versionNumber();
    }

    default int versionNumber() {
        return 1;
    }

    default String entityName() {
        return name() + "/" + version();
    }

    Backend backend();
}
