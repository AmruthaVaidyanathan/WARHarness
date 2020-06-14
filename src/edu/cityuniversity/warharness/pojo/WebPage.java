package edu.cityuniversity.warharness.pojo;

public class WebPage {

    private String url;
    private String title;
    private String contents;

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }

    public WebPage(String url, String title, String contents) {
        this.url = url;
        this.title = title;
        this.contents = contents;
    }
}
