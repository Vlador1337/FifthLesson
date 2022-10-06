import models.Result;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;


import static api_steps.RickAndMortyApiSteps.*;
import static utils.Const.*;

public class RunRickAndMortyApiTests {


    @Test
    @DisplayName("Получение информации по персонажу Морти Смит")
    public void getInfoAboutMortySmith() {
        List<Result> characterProp = getInfoAboutCharacter(MORTY_SMITH);
        characterProp.forEach(System.out::println);
    }

    @Test
    @DisplayName("Получение из списка последнего эпизода ID последнего персонажа")
    public void getLastCharacterIdInLastEpisode() {
        System.out.println("ID последнего персонажа из последнего эпизода - " +
                getLastCharacterIdFromEpisode(getLastEpisodeId()));
    }

    @Test
    @DisplayName("Получение информации по последнему персонажу из последнего эпизода")
    public void getInfoAboutLastCharacterFromLastEpisode() {
        Result lastCharInfo = getInfoAboutCharacter(getLastCharacterIdFromEpisode(getLastEpisodeId()));
        System.out.println(lastCharInfo);
    }

    @Test
    @DisplayName("Сравнение локаций и рас у Морти Смита и последнего персонажа")
    public void compareCharactersLocationAndSpecies() {
        Result firstMorty = getInfoAboutCharacter(MORTY_SMITH).get(0);
        Result lastCharacter = getInfoAboutCharacter(getLastCharacterIdFromEpisode(getLastEpisodeId()));

        Assertions.assertEquals(firstMorty.getSpecies(), lastCharacter.getSpecies(),
                "Персонажи имеют разные расы");
        Assertions.assertEquals(firstMorty.getLocation().getName(), lastCharacter.getLocation().getName(),
                "Персонажи находятся в разных локациях");
    }
}
