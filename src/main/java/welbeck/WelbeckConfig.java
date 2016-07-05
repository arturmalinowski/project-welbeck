package welbeck;

import org.springframework.context.annotation.Bean;
import welbeck.repositories.PageRepository;

public class WelbeckConfig {

    @Bean
    public PageRepository pageRepository() {
        return new PageRepository();
    }
}
