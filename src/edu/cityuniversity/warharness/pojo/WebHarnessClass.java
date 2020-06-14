package edu.cityuniversity.warharness.pojo;

import java.util.List;

/**
 * @author rajarar
 */
public class WebHarnessClass {
    private List<String> imports;
    private String className;
    private List<Method> methodList;

    public List<String> getImports() {
        return imports;
    }

    public String getClassName() {
        return className;
    }

    public List<Method> getMethodList() {
        return methodList;
    }

    public WebHarnessClass(List<String> imports, String className, List<Method> methodList) {
        this.imports = imports;
        this.className = className;
        this.methodList = methodList;
    }

    public class Method {
        private String returns;
        private String methodName;
        private String contents;
        private List<String> annotations;

        public String getReturns() {
            return returns;
        }

        public String getMethodName() {
            return methodName;
        }

        public String getContents() {
            return contents;
        }

        public List<String> getAnnotations() {
            return annotations;
        }

        public Method(String returns, String methodName, String contents, List<String> annotations) {
            this.returns = returns;
            this.methodName = methodName;
            this.contents = contents;
            this.annotations = annotations;
        }
    }

    @Override
    public String toString() {
        return className;
    }
}
