package top.cfish.basicweb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: isisiwish
 * @date: 2019/5/9
 * @time: 10:14
 */
@RestController
public class HelloWorldController
{
    @RequestMapping("/hello")
    public String hello(String name)
    {
        return "Hello World " + name;
    }
}
