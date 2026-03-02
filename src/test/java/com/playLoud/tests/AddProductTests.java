package com.playLoud.tests;

import com.playLoud.core.TestBase;
import com.playLoud.dto.login.LoginRequestDto;
import com.playLoud.dto.product.ProductsRequestDto;
import com.playLoud.dto.product.ProductsResponseDto;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AddProductTests extends TestBase {

    String token;

    @BeforeEach
    public void preRequest() {
        String responseToken = login(LoginRequestDto.of(EMAIL, PASSWORD))
                .extract().body().path("accessToken");
        token = responseToken;
    }

    ProductsRequestDto product = new ProductsRequestDto(
            "Fender",
            "Antique thing",
            1000,
            false,
            Paths.get("/Users/baker/Tools/images.jpeg"),
            1
    );

    @Test
    public void addProductsSuccessTest() {
        ProductsResponseDto products = given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.MULTIPART)
                .multiPart("title", this.product.title())
                .multiPart("description", this.product.description())
                .multiPart("price", this.product.price())
                .multiPart("isArchived", this.product.isArchived())
                .multiPart("file", this.product.file().toFile(), "image/jpeg")
                .multiPart("categoryId", this.product.categoryId())
                .when()
                .post(PRODUCTS_PATH)
                .then()
                .assertThat().statusCode(201)
                .assertThat().body("title", equalTo("Fender"))
                .extract().as(ProductsResponseDto.class);

        System.out.println(products.id() + " *** " + products.title());
    }
}
