package com.hospetal.hospital.service;

import com.hospetal.hospital.domain.Hospital;
import com.hospetal.hospital.dto.request.HospitalPostRequestDto;
import com.hospetal.hospital.dto.response.HospitalPostResponseDto;
import com.hospetal.hospital.repository.HospitalRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class HospitalService {
    private final HospitalRepository hospitalRepository;

    public HospitalPostResponseDto addHospital(HospitalPostRequestDto requestDto) {
        Hospital hospital = toEntity(requestDto);
        Hospital savedEntity = hospitalRepository.save(hospital);
        return toResponseDto(savedEntity);
    }

    private HospitalPostResponseDto toResponseDto(Hospital entity) {
        return HospitalPostResponseDto.builder()
                .id(entity.getId())
                .build();
    }

    private Hospital toEntity(HospitalPostRequestDto requestDto) {
        return Hospital.builder()
                .name(requestDto.getName())
                .description(requestDto.getDescription())
                .contactNumber(requestDto.getContactNumber())
                .build();
    }
}
