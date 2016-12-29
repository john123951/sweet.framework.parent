package sweet.framework.service.framework.web.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/")
public class ExampleController {

    @RequestMapping
    public String index() {
        return new Date().toString();
    }
}
