package edu.cityuniversity.warharness.transform;

import com.google.common.collect.ImmutableList;
import edu.cityuniversity.warharness.pojo.WebHarnessClass;
import edu.cityuniversity.warharness.pojo.WebPage;

/**
 * @author rajarar
 */
public class WarHarnessParser implements Parser {

    @Override
    public WebHarnessClass parse(WebPage page) {
        final String contents = page.getContents();
        return new WebHarnessClass(ImmutableList.of(), page.getTitle(), ImmutableList.of());
    }

}
