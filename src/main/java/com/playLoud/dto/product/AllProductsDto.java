package com.playLoud.dto.product;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AllProductsDto(@JsonProperty("data")List<ProductsResponseDto> data,
                             Integer total) {

    public static AllProductsDto of(List<ProductsResponseDto>data,
                                    Integer total) {
        return new AllProductsDto(data,total);
    }
}
