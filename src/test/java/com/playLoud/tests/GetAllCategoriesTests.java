package com.playLoud.tests;

import com.playLoud.core.TestBase;
import com.playLoud.dto.category.CategoryResponseDto;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GetAllCategoriesTests extends TestBase {

    @Test
    public void getAllCategoriesSuccessTest() {
        CategoryResponseDto[] categories = given()
                .when()
                .get(CATEGORY_PATH)
                .then()
                .assertThat().statusCode(200)
                .extract().response().as(CategoryResponseDto[].class);

        for (CategoryResponseDto c: categories) {
            System.out.println(c.id() + " *** " + c.title());
        }
    }
}
