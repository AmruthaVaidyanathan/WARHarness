package edu.cityuniversity.warharness.crawl;

import edu.cityuniversity.warharness.pojo.WebPage;

import java.io.IOException;

/**
 * @author rajarar
 */
public interface Retriever {
    WebPage retrieve(String url) throws IOException;
}
