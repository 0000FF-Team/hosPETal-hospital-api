package com.hospetal.hospital.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/hospitals")
@RestController
public class HospitalController {

    @GetMapping
    public String get() {
        return "Hello hosPETal";
    }
}
