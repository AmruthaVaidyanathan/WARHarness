package edu.cityuniversity.warharness.service.context;

import com.google.common.collect.ImmutableList;
import edu.cityuniversity.warharness.service.operations.API;
import edu.cityuniversity.warharness.service.operations.APIs;

import java.util.List;

/**
 *
 */
public class DefaultServiceContext implements ServiceContext {

    private static final List<API> API_LIST = ImmutableList.of(
            APIs.CRAWL_API,
            APIs.HELLO_API
    );

    @Override
    public List<API> availableAPIs() {
        return API_LIST;
    }
}
