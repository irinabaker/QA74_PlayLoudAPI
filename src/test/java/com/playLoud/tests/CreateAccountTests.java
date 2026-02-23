package com.playLoud.tests;

import com.playLoud.core.TestBase;
import com.playLoud.dto.users.ErrorDto;
import com.playLoud.dto.users.UsersRequestDto;
import com.playLoud.dto.users.UsersResponseDto;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class CreateAccountTests extends TestBase {

    UsersRequestDto requestDto = UsersRequestDto.of(NAME,
            "ole" + System.currentTimeMillis() + "@gm.com",PASSWORD);

    @Test
    public void createAccountSuccessTest() {
        UsersResponseDto responseDto = given()
                .contentType(ContentType.JSON)
                .body(requestDto)
                .when()
                .post(USERS_PATH)
                .then()
                .assertThat().statusCode(201)
                .extract().response().as(UsersResponseDto.class);

        System.out.println(responseDto.id() + " *** " + responseDto.name());

        //68 *** Oliver
    }

    @Test
    public void createExistedEmailErrorTest() {
      //  ErrorDto errorDto =
                given()
                .contentType(ContentType.JSON)
                .body(UsersRequestDto.of(NAME, EMAIL, PASSWORD))
                .when()
                .post(USERS_PATH)
                .then()
                .assertThat().statusCode(409)
                .assertThat().body("message",containsString("email already exists"))
             //   .extract().response().as(ErrorDto.class)
                ;

      //  System.out.println(errorDto.message());
        // A record with this email already exists.
    }

    @Test
    public void createAccountWithInvalidPasswordErrorTest() {
        given()
                .contentType(ContentType.JSON)
                .body(UsersRequestDto.of(NAME,
                        "test" + System.currentTimeMillis() + "@gm.com",
                "123"))
                .when()
                .post(USERS_PATH)
                .then()
                .assertThat().statusCode(400)
                .assertThat().body("error",equalTo("Bad Request"));
    }
}
