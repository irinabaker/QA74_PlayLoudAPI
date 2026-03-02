package com.playLoud.dto.product;

import java.nio.file.Path;

public record ProductsRequestDto(String title,
                                 String description,
                                 Integer price,
                                 boolean isArchived,
                                 Path file,
                                 Integer categoryId) {
}
