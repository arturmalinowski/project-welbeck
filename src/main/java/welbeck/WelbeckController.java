package welbeck;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import welbeck.logic.PageChecker;
import welbeck.repositories.PageRepository;

@RestController
public class WelbeckController {

    private PageRepository pageRepository = new PageRepository();
    private PageChecker pageChecker = new PageChecker();


    @RequestMapping("/check")
    public String check() {
        Boolean check = false;
        if (check == true) {
            return "Found";
        }
        else {
            return "Not found";
        }
    }

    @RequestMapping("/list")
    public String list() {
        return pageRepository.getUrlsAsString();
    }

    @RequestMapping("/")
    public String index() {
        return "Test";
    }
}
