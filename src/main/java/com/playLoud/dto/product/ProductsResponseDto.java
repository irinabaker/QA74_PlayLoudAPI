package com.playLoud.dto.product;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ProductsResponseDto(Integer id,
                                 String title,
                                 Integer price,
                                 String description,
                                 Integer userId) {
}