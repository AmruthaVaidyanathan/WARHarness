package edu.cityuniversity.warharness.crawl;

import edu.cityuniversity.warharness.pojo.WebPage;

public interface Parser {

    WebPage parse(String contents);

}
