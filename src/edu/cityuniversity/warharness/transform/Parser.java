package edu.cityuniversity.warharness.transform;

import edu.cityuniversity.warharness.pojo.WebHarnessClass;
import edu.cityuniversity.warharness.pojo.WebPage;

public interface Parser {

    WebHarnessClass parse(WebPage page);

}
