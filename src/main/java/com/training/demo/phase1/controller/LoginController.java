package com.training.demo.phase1.controller;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.deser.ValueInstantiators;
import com.training.demo.phase1.services.impementation.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private Environment env;

    @PostMapping("/verifyLogin")
    public List<String> verifyLogin(@RequestBody Integer r) throws Exception {
        Integer i = 24;
        Integer result = loginService.verifyLogin(r);
        List<Integer> results = new ArrayList<Integer>();
        results.add(result);
        results.add(result + 2);

        String s = env.getProperty("secure_app_database.url");
        String s1 = env.getProperty("server.port");
        List<String> vars = new ArrayList<String>();
        vars.add(s);
        vars.add(s1);
        return vars;
    }
}
