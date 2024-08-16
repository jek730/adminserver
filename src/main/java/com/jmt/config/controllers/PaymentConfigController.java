package com.jmt.config.controllers;

import lombok.RequiredArgsConstructor;
import com.jmt.config.service.ConfigInfoService;
import com.jmt.config.service.ConfigSaveService;
import com.jmt.global.exceptions.ExceptionProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/config/payment")
@RequiredArgsConstructor
public class PaymentConfigController implements ExceptionProcessor, CommonConfig {
    private final ConfigInfoService infoService;
    private final ConfigSaveService saveService;

    @GetMapping
    public String index(@ModelAttribute PaymentConfig form) {
        return "config/payment";
    }

    @PostMapping
    public String save(PaymentConfig form) {

        return "config/payment";
    }
}