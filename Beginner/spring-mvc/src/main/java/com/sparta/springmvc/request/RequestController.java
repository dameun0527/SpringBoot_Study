package com.sparta.springmvc.request;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;

@Controller
@RequestMapping("/hello/request")
public class RequestController {

    @GetMapping("/form/html")
    public String helloForm() {
        return "hello-request-form";
    }

    // [Request sample]
    // GET http://localhost:8080/hello/request/request/star/Robbie/age/95

    @GetMapping("/star/{name}/age/{age}/95")
    @ResponseBody
    public String helloRequestPath(@PathVariable String name, @PathVariable int age) {
        return String.format("Hello, @RequestParam.<br> name = %s, age = %d", name, age);
    }

    // [Request sample]
// POST http://localhost:8080/hello/request/form/param
// Header
//  Content type: application/x-www-form-urlencoded
// Body
//  name=Robbie&age=95
    @PostMapping("/form/param")
    @ResponseBody
    public String helloPostRequestParam(@RequestParam String name, @RequestParam int age) {
        return String.format("Hello, @RequestParam.<br> name = %s, age = %d", name, age);
    }

}
