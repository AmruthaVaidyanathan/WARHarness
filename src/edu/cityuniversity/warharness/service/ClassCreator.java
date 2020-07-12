package edu.cityuniversity.warharness.service;

import edu.cityuniversity.warharness.pojo.WebHarnessClass;

import java.util.List;

/**
 * @author rajarar
 */
public class ClassCreator {

    private static final String NEW_LINE = "\n";
    private static final String TAB = "\t";
    private static final String LINE_DELIMITER = ";";
    private static final String OPEN_PARENTHESIS = "{";
    private static final String CLOSE_PARENTHESIS = "}";

    public static String toJavaClass(WebHarnessClass whClass) {
        StringBuilder builder = new StringBuilder();

        builder.append(addImports(whClass.getImports()));
        builder.append(NEW_LINE);
        builder.append(NEW_LINE);
        builder.append(addTestClassName(whClass.getClassName()));
        builder.append(OPEN_PARENTHESIS);
        builder.append(NEW_LINE);
        builder.append(addElements(whClass.getInputElements()));
        builder.append(addMethods(whClass.getTestList()));
        builder.append(CLOSE_PARENTHESIS);
        builder.append(NEW_LINE);
        builder.append(NEW_LINE);
        return builder.toString();
    }

    private static String addMethods(List<WebHarnessClass.Method> testList) {
        StringBuilder builder = new StringBuilder();
        builder.append(NEW_LINE);

        testList.forEach(test -> {
            test.getAnnotations().forEach(annotation -> {
                builder.append(TAB);
                builder.append("@" + annotation);
                builder.append(NEW_LINE);
            });
            builder.append(TAB);
            builder.append("public void " + test.getTestName() + "() ");
            builder.append(OPEN_PARENTHESIS);
            builder.append(NEW_LINE);
            builder.append(TAB);
            builder.append(CLOSE_PARENTHESIS);
            builder.append(NEW_LINE);
            builder.append(NEW_LINE);
        });
        return builder.toString();
    }

    private static String addElements(List<WebHarnessClass.InputElement> inputElements) {
        StringBuilder builder = new StringBuilder();
        builder.append(NEW_LINE);

        // Actual instance variables
        inputElements.forEach(element -> {
            builder.append(TAB);
            builder.append(element.getIdentifier());
            builder.append(LINE_DELIMITER);
            builder.append(NEW_LINE);
        });

        return builder.toString();
    }

    private static String addTestClassName(String className) {
        StringBuilder builder = new StringBuilder();
        builder.append("public class " + className);
        builder.append(NEW_LINE);
        return builder.toString();
    }


    private static String addImports(List<String> imports) {
        StringBuilder builder = new StringBuilder();
        imports.forEach(importedClass -> {
            builder.append("import " + importedClass);
            builder.append(NEW_LINE);
        });

        return builder.toString();
    }
}