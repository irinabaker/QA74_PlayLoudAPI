package com.playLoud.core;

import com.playLoud.dto.login.LoginRequestDto;
import com.playLoud.dto.users.UsersRequestDto;
import com.playLoud.utils.DbData;
import com.playLoud.utils.PropertiesLoader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.BeforeEach;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static io.restassured.RestAssured.given;

public class TestBase {

    public static Connection connection;

    @BeforeEach
    public void init() {
        RestAssured.baseURI = "https://khamidov.dev/playloud";
        RestAssured.basePath = "api";

        try {
            //load postgres jdbc driver
            Class.forName("org.postgresql.Driver");

            //create connection to DB
            connection = DriverManager.getConnection(DbData.dbUrl, DbData.username, DbData.password);
        }catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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


/*
ssh -L 5433:localhost:5432 root@217.154.148.226

Пароль: 1uSHJcZo

Then in Beekeeper:
Field Value
Host localhost
Port 5433
Database playloud
Username queen
Password kotikspit1*/
