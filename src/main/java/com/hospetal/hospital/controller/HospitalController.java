package com.hospetal.hospital.controller;

import com.hospetal.hospital.dto.request.HospitalPostRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@Slf4j
@RequestMapping("/hospitals")
@RestController
public class HospitalController {

    @GetMapping
    public String get() {
        return "Hello hosPETal";
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Map<String, String> post(@Valid @RequestBody HospitalPostRequestDto postRequestDto) {
        return Map.of();
    }
}
