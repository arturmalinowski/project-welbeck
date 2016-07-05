package welbeck.logic;

import org.junit.Before;
import org.junit.Test;
import welbeck.domain.Url;
import welbeck.repositories.PageRepository;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;


public class PageCheckerTest {
    private PageChecker pageChecker;
    private PageRepository pageRepository;

    @Before
    public void setUp() throws Exception {
        pageChecker = new PageChecker();
        pageRepository = new PageRepository();

        pageRepository.add(new Url("http://www.google.com"), "google", new BigDecimal(20));
    }

    @Test
    public void checkThatPageBodyIsReturned() {
        assertThat(pageChecker.checkOn(pageRepository.getUrls())).containsPattern("google");
    }

}