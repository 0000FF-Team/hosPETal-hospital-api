package com.hospetal.hospital.service;

import com.hospetal.hospital.dto.request.HospitalPostRequestDto;
import com.hospetal.hospital.repository.HospitalRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;

class HospitalServiceTest {

    private HospitalService hospitalService;
    @Mock
    private HospitalRepository hospitalRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        hospitalService = new HospitalService(hospitalRepository);
    }

    @AfterEach
    void teardown() throws Exception {
        MockitoAnnotations.openMocks(this).close();
    }

    @Test
    void addHospital() {
        HospitalPostRequestDto dto = HospitalPostRequestDto.builder().build();
        Long hospitalId = hospitalService.addHospital(dto);
        assertThat(hospitalId).isEqualTo(1L);
    }
}