package com.example.webservice.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    //  Static Filtering

    @GetMapping("/static/filtering")
    public SomeBean staticFiltering() {
        return new SomeBean("value1", "value2", "value3");
    }

    @GetMapping("/static/filtering-list")
    public List<SomeBean> staticFilteringList() {
        return List.of(new SomeBean("value1", "value2", "value3"),
                new SomeBean("value3", "value4", "value5"));
    }

//    Dynamic Filtering

    @GetMapping("/dynamic/filtering")
    public MappingJacksonValue dynamicFiltering() {

        SomeBean someBean = new SomeBean("value1", "value2", "value3");

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);

        createFilters(mappingJacksonValue);

        return mappingJacksonValue;

    }

    @GetMapping("/dynamic/filtering-list")
    public MappingJacksonValue dynamicFilteringList() {

        List<SomeBean> list = Arrays.asList(new SomeBean("value1", "value2", "value3"),
                new SomeBean("value4", "value5", "value6"));

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);

        createFilters(mappingJacksonValue);

        return mappingJacksonValue;
    }

    private void createFilters(MappingJacksonValue mappingJacksonValue) {
        SimpleBeanPropertyFilter filter =
                SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");

        FilterProvider filters =
                new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);

        mappingJacksonValue.setFilters(filters);
    }
}
