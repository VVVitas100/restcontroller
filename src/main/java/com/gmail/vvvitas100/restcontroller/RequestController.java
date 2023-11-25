package com.gmail.vvvitas100.restcontroller;
import java.util.Map;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
public class RequestController {

    @RequestMapping(value = "count", method = RequestMethod.GET)
    public Map<Character,Long> getResponse(@RequestParam(value = "text", defaultValue = "") String in) {
        return StringCharsCount.getCount(in);
    }
}