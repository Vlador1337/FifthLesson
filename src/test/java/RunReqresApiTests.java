import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static api_steps.ReqresApiSteps.*;

public class RunReqresApiTests {
    @Test
    @DisplayName("Создание нового пользователя")
    public void createUserForReqres() throws IOException {
        createUser();
    }
}
