package edu.cityuniversity.warharness.transform;

import com.google.common.collect.ImmutableList;
import edu.cityuniversity.warharness.crawl.JsoupRetriever;
import edu.cityuniversity.warharness.pojo.WebHarnessClass;
import edu.cityuniversity.warharness.pojo.WebPage;
import edu.cityuniversity.warharness.service.Utilities;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author rajarar
 */
public class WarHarnessParser implements Parser {

    private static final List<String> TEST_ANNOTATIONS = ImmutableList.of(
            "Test"
    );

    @Override
    public WebHarnessClass parse(WebPage page) {
        // build all variables for creating a test class
        final String contents = page.getContents();
        final List<WebHarnessClass.Method> tests = getTestMethods(contents);
        final ImmutableList<String> imports = ImmutableList.of();

        return new WebHarnessClass(imports, page.getTitle(), tests, inputVariables(contents));
    }

    private List<WebHarnessClass.InputElement> inputVariables(String contents) {
        Document document = Jsoup.parseBodyFragment(contents);
        Elements inputElements = document.body().getElementsByTag("input");
        Set<WebHarnessClass.InputElement> variables = new HashSet<>();
        for (Element inputElement : inputElements) {
            if (!"submit".equals(inputElement.attr("type"))) {
                variables.add(parseInputElement(inputElement));
            }
        }

        return new ArrayList<>(variables);
    }

    private WebHarnessClass.InputElement parseInputElement(Element inputElement) {
        final WebHarnessClass.InputElement element;

        if (inputElement.hasAttr("id")) {
            element = new WebHarnessClass.InputElement(WebHarnessClass.InputElement.Type.ID, inputElement.attr("id"));
        } else {
            element = new WebHarnessClass.InputElement(WebHarnessClass.InputElement.Type.NAME, inputElement.attr("name"));
        }

        return element;
    }

    // Can be <input> - submit/button
    // Can be <button>
    // Can be <a>
    private List<WebHarnessClass.Method> getTestMethods(String contents) {
        Document document = Jsoup.parseBodyFragment(contents);
        Elements inputElements = document.getElementsByTag("input");
        inputElements.addAll(document.getElementsByTag("a"));
        inputElements.addAll(document.getElementsByTag("button"));

        Set<WebHarnessClass.Method> methods = new HashSet<>();
        for (Element inputElement : inputElements) {
            if (inputElement.tag().getName().equals("input")) {
                if ("submit".equals(inputElement.attr("type"))) {
                    methods.add(createMethod(inputElement, "value"));
                }
            } else if (inputElement.tag().getName().equals("button")) {
                methods.add(createMethod(inputElement, "class"));
            }
        }

        return new ArrayList<>(methods);
    }

    private WebHarnessClass.Method createMethod(Element inputElement, String attributeToCheck) {
        return new WebHarnessClass.Method("void", Utilities.toCamelcase(inputElement.attr(attributeToCheck), " "), "", TEST_ANNOTATIONS);
    }

    public static void main(String[] args) throws IOException {
        WarHarnessParser parser = new WarHarnessParser();
        parser.parse(new JsoupRetriever().retrieve("https://www.glassdoor.com/index.html"));
    }

}
