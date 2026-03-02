package com.playLoud.dto.category;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CategoryResponseDto(Integer id,
                                  String title) {
    public static CategoryResponseDto of(Integer id,String title) {
        return new CategoryResponseDto(id,title);
    }
}
