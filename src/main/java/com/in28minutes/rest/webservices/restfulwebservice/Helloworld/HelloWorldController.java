package com.in28minutes.rest.webservices.restfulwebservice.Helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping(path = "/hello-world")
    public String HelloWord(){
        return "Hello World";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWordBean HelloWordBean(){
        return new HelloWordBean("Hello World");
    }

    @GetMapping(path = "/Hello-word/path-variable/{name}")
    public HelloWordBean PathVariable(@PathVariable String name){
        return new HelloWordBean(String.format("Hello word, %s", name));
    }

}
