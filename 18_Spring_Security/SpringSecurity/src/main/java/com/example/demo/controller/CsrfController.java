package com.example.demo.controller;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/csrf")
public class CsrfController {
    @GetMapping
    public CsrfToken csrf(@RequestBody request) {
        return (CsrfToken) request.getAttribute(CsrfToken.class.getName());
    }
}