package com.hospetal.hospital.service;

import com.hospetal.hospital.domain.Hospital;
import com.hospetal.hospital.dto.request.HospitalPostRequestDto;
import com.hospetal.hospital.dto.response.HospitalPostResponseDto;
import com.hospetal.hospital.repository.HospitalRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

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
    @DisplayName("병원 등록 성공")
    void addHospital() {
        // given
        given(hospitalRepository.save(any(Hospital.class)))
                .willReturn(generateHospitalEntity());

        // when
        HospitalPostResponseDto result = hospitalService.addHospital(generatePostRequestDto());

        // then
        assertThat(result.getId()).isEqualTo(5L);
        verify(hospitalRepository).save(any(Hospital.class));
    }

    private Hospital generateHospitalEntity() {
        return Hospital.builder()
                .id(5L)
                .name("블루동물병원")
                .description("블루동물병원입니다.")
                .contactNumber("0329997777")
                .build();
    }

    private HospitalPostRequestDto generatePostRequestDto() {
        return HospitalPostRequestDto.builder()
                .name("블루동물병원")
                .description("블루동물병원입니다.")
                .contactNumber("0329997777")
                .build();
    }
}