package com.duoc.veterinaria.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SecuredController {

    @GetMapping("/greetings")
    public String greetings(@RequestParam(value="name", defaultValue="World") String name) {
        return "Hola {" + name + "}, este es un mensaje protegido por JWT";
    }
}