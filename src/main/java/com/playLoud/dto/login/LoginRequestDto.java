package com.playLoud.dto.login;

import com.fasterxml.jackson.annotation.JsonProperty;

public record LoginRequestDto(@JsonProperty("email") String email,
                              @JsonProperty("password") String password) {

    public static LoginRequestDto of(String email,String password) {
        return new LoginRequestDto(email,password);
    }
}
