package com.imusic.hystrix.quickstart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloWorldController  {

    @Autowired HelloWorldCommand helloWorldCommand;

    @RequestMapping(value = "/hello/{msg}")
    public String hello(@PathVariable(value = "msg") String name) {
        return helloWorldCommand.sayHello(name);
    }
    
    
    
    
}
