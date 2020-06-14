package edu.cityuniversity.warharness.service.backend;

import edu.cityuniversity.warharness.crawl.WebPageRetriever;
import edu.cityuniversity.warharness.pojo.WebHarnessClass;
import edu.cityuniversity.warharness.pojo.WebPage;
import edu.cityuniversity.warharness.service.entity.Request;
import edu.cityuniversity.warharness.service.entity.Response;
import edu.cityuniversity.warharness.service.handler.throttling.ErrorResponses;
import edu.cityuniversity.warharness.transform.WarHarnessParser;

import java.io.IOException;
import java.util.Optional;

/**
 * Provided a Request with body
 */
public class CrawlBackend implements Backend {

    private final WebPageRetriever retriever;
    private final WarHarnessParser parser;

    public CrawlBackend() {
        retriever = new WebPageRetriever();
        parser = new WarHarnessParser();
    }

    @Override
    public Response serve(final Request request) {
        Optional<String> url = request.queryValue("url");
        try {
            if (url.isPresent()) {
                WebPage webPage = retriever.retrieve(url.get());
                WebHarnessClass whClass = parser.parse(webPage);
                return Response.builder()
                        .withPayload("{\"source\":\"" + whClass + "\"}")
                        .withStatusCode(200)
                        .withContentType("application/json")
                        .build();
            }

            return ErrorResponses.badRequest("Url not present");
        } catch (IOException e) {
            return ErrorResponses.failure(String.format("Failure: %s", e.getMessage()));
        }
    }
}
