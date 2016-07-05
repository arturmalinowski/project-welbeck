package welbeck.repositories;

import org.junit.Before;
import org.junit.Test;
import welbeck.domain.Url;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;


public class PageRepositoryTest {
    private PageRepository pageRepository;

    @Before
    public void setUp() throws Exception {
        pageRepository = new PageRepository();
        pageRepository.add(new Url("www.test.com"), "test", new BigDecimal(10));
        pageRepository.add(new Url("www.google.com"), "google", new BigDecimal(20));
    }

    @Test
    public void returnAListOfUrlsAsString() {
        assertThat(pageRepository.getUrlsAsString()).isEqualTo("www.test.com, www.google.com");
    }
}