package com.playLoud.tests;

import com.playLoud.core.TestBase;
import com.playLoud.dto.login.LoginRequestDto;
import com.playLoud.dto.login.LoginResponseDto;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class LoginTests extends TestBase {

    LoginRequestDto requestDto = LoginRequestDto.of(EMAIL,PASSWORD);

    @Test
    public void loginSuccessTest() {
        LoginResponseDto loginDto = login(requestDto)
                .statusCode(201)
                .extract().response().as(LoginResponseDto.class);

        System.out.println(loginDto.accessToken());
    }

}
