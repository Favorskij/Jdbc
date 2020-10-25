package com.testjdbc.controller;

import com.testjdbc.repository.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @Autowired
    public MyRepository myRepository;

    @ResponseBody
    @GetMapping(value = "/")
    public String home () {
        return myRepository.getByUsername("Roma").getUsername();
    }


}
