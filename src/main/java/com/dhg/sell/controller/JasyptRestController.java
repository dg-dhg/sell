package com.dhg.sell.controller;

import com.dhg.sell.domain.ajax.AjaxResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jas")
public class JasyptRestController{
    @Value("${jas.test.input}")
    private String input;

    @GetMapping("/input/{id}")
    public AjaxResponse getInput(@PathVariable long id) {
        return AjaxResponse.success(input);
    }

}
