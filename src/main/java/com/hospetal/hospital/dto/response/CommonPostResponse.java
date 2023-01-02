package com.hospetal.hospital.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CommonPostResponse<T> {
    private String message;
    private T data;
}
