package welbeck.repositories;

import welbeck.domain.Page;
import welbeck.domain.Url;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PageRepository {

    private List<Page> pageList = new ArrayList<>();

    public PageRepository() {
    }

    public void add(Url url, String type, BigDecimal targetPrice) {
        pageList.add(new Page(url, type, targetPrice));
    }

    public String getUrlsAsString() {
        return pageList.stream().map(page -> page.getUrl().getUrlAsString()).collect(Collectors.joining(", "));
    }

    public List<Url> getUrls() {
        return pageList.stream().map(page -> page.getUrl()).collect(Collectors.toList());
    }

    public List<Page> getPageList() {
        return pageList;
    }
}
