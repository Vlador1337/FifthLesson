package api_steps;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static utils.Const.*;

public class ReqresApiSteps {
    public static void createUser() throws IOException {
        JSONObject requestBody = new JSONObject(new String(Files.readAllBytes(Paths.get("src/test/resources/reqres.json"))));
        requestBody.put(NAME, "Tomato");
        requestBody.put(JOB, "Eat market");

        Response response = given()
                .baseUri("https://reqres.in/")
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post("api/users")
                .then().log().all()
                .statusCode(201)
                .extract().response();

        JSONObject newUserBody = new JSONObject(response.getBody().asString());

        Assertions.assertEquals(newUserBody.getString(NAME),
                requestBody.getString(NAME), "Имена не совпадают");
        Assertions.assertEquals(newUserBody.getString(JOB),
                requestBody.getString(JOB), "Работа не совпадает");
        Assertions.assertNotNull(newUserBody.getString(ID), "ID пустое");
        Assertions.assertNotNull(newUserBody.getString(CREATED_AT), "Дата создания пустая");
    }
}
