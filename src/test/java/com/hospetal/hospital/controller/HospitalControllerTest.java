package com.hospetal.hospital.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hospetal.hospital.dto.request.HospitalPostRequestDto;
import com.hospetal.hospital.service.HospitalService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HospitalController.class)
class HospitalControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HospitalService hospitalService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("/hospitals 요청 시 Hello hosPETal을 출력한다")
    void get() throws Exception {
        // expected
        mockMvc.perform(MockMvcRequestBuilders.get("/hospitals"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello hosPETal"))
                .andDo(print());
    }

    @Test
    @DisplayName("/hospitals 요청 시 {}을 출력한다")
    void post() throws Exception {
        String postRequestContent = objectMapper.writeValueAsString(
                HospitalPostRequestDto.builder()
                        .name("블루동물병원")
                        .description("블루동물병원입니다")
                        .build());

        mockMvc.perform(MockMvcRequestBuilders.post("/hospitals")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(postRequestContent)
                )
                .andExpect(status().isCreated())
                .andExpect(content().string(""))
                .andDo(print());

        verify(hospitalService).addHospital(any(HospitalPostRequestDto.class));
    }
}