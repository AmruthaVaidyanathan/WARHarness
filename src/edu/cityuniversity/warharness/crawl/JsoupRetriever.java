package edu.cityuniversity.warharness.crawl;

import edu.cityuniversity.warharness.pojo.WebPage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

/**
 * @author rajarar
 */
public class JsoupRetriever implements Retriever {

    @Override
    public WebPage retrieve(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
        final String title = doc.title();
        return new WebPage(url, title, doc.body().toString());
    }

}
