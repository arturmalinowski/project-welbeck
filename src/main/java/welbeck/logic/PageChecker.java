package welbeck.logic;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import welbeck.domain.Page;

import java.io.IOException;
import java.math.BigDecimal;

public class PageChecker {
    public Boolean checkOn(Page page) {
        HttpClient httpClient = HttpClientBuilder.create().build();
        PriceExtractor priceExtractor = new PriceExtractor();

        HttpGet httpGet = new HttpGet(page.getUrl().getUrlAsString());
        String body = getBody(httpClient, httpGet);
        BigDecimal price = priceExtractor.extractPrice(body);

        int value = price.compareTo(page.getTargetPrice());
        if(value < 0 && value == 0) {
            return true;
        } else {
            return false;
        }
    }

    private String getBody(HttpClient httpClient, HttpGet httpGet) {
        HttpEntity entity;
        try {
            HttpResponse response = httpClient.execute(httpGet);
            entity = response.getEntity();
            return EntityUtils.toString(entity);
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed fetching the page.";
        }
    }
}
