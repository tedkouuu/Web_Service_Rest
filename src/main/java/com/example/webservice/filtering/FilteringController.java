package com.example.webservice.filtering;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//  Static Filtering

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public SomeBean filtering() {
        return new SomeBean("value1", "value2", "value3");
    }

    @GetMapping("/filtering-list")
    public List<SomeBean> filteringList() {
        return List.of(new SomeBean("value1", "value2", "value3"),
                new SomeBean("value3", "value4", "value5"));
    }

}
