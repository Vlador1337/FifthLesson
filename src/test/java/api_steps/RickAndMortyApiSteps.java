package api_steps;

import models.Result;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static utils.Const.*;

public class RickAndMortyApiSteps {

    public static List<Result> getInfoAboutCharacter(String characterName) {
        Spec.setSpecification(Spec.requestSpecification(), Spec.responseSpecification());
        return given()
                .param(NAME, characterName)
                .get("character/")
                .then()
                .extract().body().jsonPath().getList(RESULTS, Result.class);
    }

    public static Result getInfoAboutCharacter(int characterId) {
        Spec.setSpecification(Spec.requestSpecification(), Spec.responseSpecification());
        return given()
                .get("character/" + characterId)
                .then()
                .extract().body().as(Result.class);
    }

    public static int getLastEpisodeId() {
        Spec.setSpecification(Spec.requestSpecification(), Spec.responseSpecification());
        return given()
                .when()
                .get(EPISODE)
                .then()
                .extract().body().jsonPath().getInt("info.count");
    }

    public static int getLastCharacterIdFromEpisode(int episodeId) {
        Spec.setSpecification(Spec.requestSpecification(), Spec.responseSpecification());
        ArrayList<String> charactersFromEpisode = given()
                .when()
                .get("episode/" + episodeId)
                .then()
                .extract().body().jsonPath().getJsonObject(CHARACTERS);

        String lastCharacter = charactersFromEpisode.get(charactersFromEpisode.size() - 1);
        return Integer.parseInt(lastCharacter.split("/")[5]);
    }
}
