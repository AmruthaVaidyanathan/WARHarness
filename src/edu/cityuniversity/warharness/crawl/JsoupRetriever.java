package edu.cityuniversity.warharness.crawl;

import edu.cityuniversity.warharness.logger.ConsoleLogger;
import edu.cityuniversity.warharness.pojo.WebPage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * @author rajarar
 */
public class JsoupRetriever implements Retriever {

    @Override
    public WebPage retrieve(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
        final String title = doc.title();
        final String contents = doc.body().data();
        Elements inputElements = doc.body().getElementsByTag("input");
        for (Element inputElement : inputElements) {
            ConsoleLogger.log(inputElement.toString());
        }
        return new WebPage(url, title, contents);
    }
}
