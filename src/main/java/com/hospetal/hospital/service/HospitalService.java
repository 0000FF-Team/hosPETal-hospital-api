package com.hospetal.hospital.service;

import com.hospetal.hospital.dto.request.HospitalPostRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class HospitalService {
    public Long addHospital(HospitalPostRequestDto requestDto) {
        return 1L;
    }
}
