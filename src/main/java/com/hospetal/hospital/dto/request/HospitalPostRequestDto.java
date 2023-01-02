package com.hospetal.hospital.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@ToString
@Builder
@Getter
@Setter
public class HospitalPostRequestDto {

    @NotBlank(message = "병원 이름을 입력해주세요.")
    private String name;
    @NotEmpty(message = "병원 소개를 입력해주세요.")
    private String description;
    @NotBlank(message = "병원 전화번호를 입력해주세요.")
    private String contactNumber;
}
