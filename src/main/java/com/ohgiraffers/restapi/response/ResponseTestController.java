package com.ohgiraffers.restapi.response;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/response")
public class ResponseTestController {


    @GetMapping("/hello")
    public String helloWorld() {
        System.out.println("hello world");

        return "hello world!";
    }


    @GetMapping("/random")
    public void getRandomNumber() {

        return;
    }
}
