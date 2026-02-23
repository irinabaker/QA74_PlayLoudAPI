package com.playLoud.tests;

import com.playLoud.core.TestBase;
import com.playLoud.dto.login.LoginRequestDto;
import com.playLoud.dto.login.LoginResponseDto;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class LoginTests extends TestBase {

    LoginRequestDto requestDto = LoginRequestDto.of(EMAIL,PASSWORD);

    @Test
    public void loginSuccessTest() {
        LoginResponseDto loginDto = given()
                .contentType(ContentType.JSON)
                .body(requestDto)
                .when()
                .post(LOGIN_PATH)
                .then()
                .statusCode(201)
                .extract().response().as(LoginResponseDto.class);

        System.out.println(loginDto.accessToken());
        // eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOjY4LCJpYXQiOjE3NzE4NDcwMDAsImV4cCI6MTc3MTg0ODIwMH0.Lokpi4BDDFA94cJNMrW3DqILe3c8Fco_E-40E9c_KBU
    }
}
