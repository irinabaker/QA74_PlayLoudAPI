package com.playLoud.core;

import com.playLoud.dto.login.LoginRequestDto;
import com.playLoud.dto.users.UsersRequestDto;
import com.playLoud.utils.PropertiesLoader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.BeforeEach;

import static io.restassured.RestAssured.given;

public class TestBase {

    @BeforeEach
    public void init() {
        RestAssured.baseURI = "https://khamidov.dev/playloud";
        RestAssured.basePath = "api";
    }

    public static final String NAME = PropertiesLoader.loadProperty("user.name");
    public static final String EMAIL = PropertiesLoader.loadProperty("user.email");
    public static final String PASSWORD = PropertiesLoader.loadProperty("user.password");

    public static final String USERS_PATH = PropertiesLoader.loadProperty("users.path");
    public static final String LOGIN_PATH = PropertiesLoader.loadProperty("login.path");
    public static final String PRODUCTS_PATH = PropertiesLoader.loadProperty("products.path");
    public static final String CATEGORY_PATH = PropertiesLoader.loadProperty("category.path");

    public ValidatableResponse login(LoginRequestDto loginDto) {
        return given()
                .contentType(ContentType.JSON)
                .body(loginDto)
                .when()
                .post(LOGIN_PATH)
                .then();
    }

    public ValidatableResponse register(UsersRequestDto registerDto) {
        return given()
                .contentType(ContentType.JSON)
                .body(registerDto)
                .when()
                .post(USERS_PATH)
                .then();
    }
}
