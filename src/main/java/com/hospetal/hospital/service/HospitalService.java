package com.hospetal.hospital.service;

import com.hospetal.hospital.domain.Hospital;
import com.hospetal.hospital.dto.request.HospitalPostRequestDto;
import com.hospetal.hospital.repository.HospitalRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class HospitalService {
    private final HospitalRepository hospitalRepository;

    public Long addHospital(HospitalPostRequestDto requestDto) {
        Hospital hospital = Hospital.builder()
                .name(requestDto.getName())
                .description(requestDto.getDescription())
                .contactNumber(requestDto.getContactNumber())
                .build();
        hospitalRepository.save(hospital);
        return 1L;
    }
}
