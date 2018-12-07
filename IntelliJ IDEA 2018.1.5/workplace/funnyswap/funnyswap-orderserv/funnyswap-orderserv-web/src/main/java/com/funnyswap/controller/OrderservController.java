package com.funnyswap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/orderserv")
public class OrderservController {
    @RequestMapping(value = "/query",method = RequestMethod.POST)
    public String a(){
        return "a";
    }
}
