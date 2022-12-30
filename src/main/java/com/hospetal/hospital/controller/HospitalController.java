package com.hospetal.hospital.controller;

import com.hospetal.hospital.dto.request.HospitalPostRequestDto;
import com.hospetal.hospital.service.HospitalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/hospitals")
@RestController
public class HospitalController {

    private final HospitalService hospitalService;

    @GetMapping
    public String get() {
        return "Hello hosPETal";
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Long post(@Valid @RequestBody HospitalPostRequestDto requestDto) {
        return hospitalService.addHospital(requestDto);
    }
}
