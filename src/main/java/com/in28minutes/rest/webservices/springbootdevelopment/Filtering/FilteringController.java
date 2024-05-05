package com.in28minutes.rest.webservices.springbootdevelopment.Filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public MappingJacksonValue filtering() {
        SomeBean someBean = new SomeBean("value1", "value2", "value3");

        //Using customized Filtering --> Dynamic Filtering
        //Using MappingJacksonValue to pass our defined class

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
        PropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field3","field2");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);

        //setting filters and returning it
        mappingJacksonValue.setFilters(filters);

        return mappingJacksonValue;
    }

    @GetMapping("/filtering-list")
    public MappingJacksonValue filteringByList(){

        List<SomeBean> someBeanList = Arrays.asList(new SomeBean("value1", "value2", "value3"),
                new SomeBean("value4", "value5", "value6"),
                new SomeBean("value7", "value8", "value9"));

        //MappingJacksonValue --> Filtering Logic

        MappingJacksonValue mappingJacksonValue2 = new MappingJacksonValue(someBeanList);
        PropertyFilter filter2 = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field3");
        FilterProvider filters2 = new SimpleFilterProvider().addFilter("SomeBeanFilter",filter2);
        mappingJacksonValue2.setFilters(filters2);

        return mappingJacksonValue2;
    }
}
