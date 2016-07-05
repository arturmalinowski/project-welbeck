package welbeck.domain;

import java.math.BigDecimal;

public class Page {
    private Url url;
    private String type;
    private BigDecimal targetPrice;

    public Page(Url url, String type, BigDecimal targetPrice) {
        this.url = url;
        this.type = type;
        this.targetPrice = targetPrice;
    }

    public Url getUrl() {
        return url;
    }
}
