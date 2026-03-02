package com.playLoud.tests;

import com.playLoud.core.TestBase;
import com.playLoud.dto.product.AllProductsDto;
import com.playLoud.dto.product.ProductsResponseDto;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GetAllProductsTests extends TestBase {

    @Test
    public void getAllProductsSuccessTest() {
        AllProductsDto products = given()
                .when()
                .get(PRODUCTS_PATH)
                .then()
                .assertThat().statusCode(200)
                .extract().response().as(AllProductsDto.class);

        for (ProductsResponseDto p: products.data()) {
            System.out.println(p.id());
            System.out.println(p.title());
            System.out.println(p.description());
            System.out.println(p.price());
            System.out.println(p.userId());
            System.out.println("**************************");
        }
    }
}
