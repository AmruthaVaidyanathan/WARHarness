package edu.cityuniversity.warharness.pojo;

import edu.cityuniversity.warharness.service.ClassCreator;
import edu.cityuniversity.warharness.service.Utilities;

import java.util.List;
import java.util.Objects;

/**
 * @author rajarar
 */
public class WebHarnessClass {
    private final List<String> imports;
    private final String className;
    private final List<Method> testList;
    private final List<InputElement> inputElements;

    public List<String> getImports() {
        return imports;
    }

    public String getClassName() {
        return className;
    }

    public List<Method> getTestList() {
        return testList;
    }

    public List<InputElement> getInputElements() {
        return inputElements;
    }

    public WebHarnessClass(List<String> imports, String className, List<Method> testList, List<InputElement> inputElements) {
        this.imports = imports;
        this.className = Utilities.toCamelcase(className, " ");
        this.testList = testList;
        this.inputElements = inputElements;
    }

    public static final class Method {
        private String returns;
        private String testName;
        private String contents;
        private List<String> annotations;

        public String getReturns() {
            return returns;
        }

        public String getTestName() {
            return testName;
        }

        public String getContents() {
            return contents;
        }

        public List<String> getAnnotations() {
            return annotations;
        }

        public Method(String returns, String testName, String contents, List<String> annotations) {
            this.returns = returns;
            this.testName = testName;
            this.contents = contents;
            this.annotations = annotations;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null) return false;
            if (!(o instanceof Method)) return false;

            Method that = (Method) o;
            return this.getTestName().equals(that.getTestName());
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(this.getTestName());
        }
    }

    public static final class InputElement {

        public enum Type {
            ID,
            NAME
        }

        private final Type type;
        private final String identifier;

        public InputElement(Type type, String identifier) {
            this.type = type;
            this.identifier = identifier;
        }

        public Type getType() {
            return type;
        }

        public String getIdentifier() {
            return identifier;
        }
    }

    @Override
    public String toString() {
        return ClassCreator.toJavaClass(this);
    }
}
