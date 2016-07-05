package welbeck.domain;

public class Url {
    private String url;

    public Url(String url) {
        this.url = url;
    }

    public String getUrlAsString() {
        return url;
    }

    public Url getUrl(){
        return this;
    }
}
