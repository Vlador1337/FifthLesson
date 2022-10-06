package api_steps;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Spec {
    public static RequestSpecification requestSpecification() {
        return new RequestSpecBuilder()
                .setBaseUri("https://rickandmortyapi.com/api")
                .setContentType(ContentType.JSON)
                .build();
    }

    public static ResponseSpecification responseSpecification() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }

    public static void setSpecification(RequestSpecification request, ResponseSpecification response) {
        RestAssured.requestSpecification = request;
        RestAssured.responseSpecification = response;
    }
}
