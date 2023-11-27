package shop.pbandj.board;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@Configuration
@RestController
public class TestController {
    @GetMapping("")
    public String test() {
        return "hello";
    }
}
