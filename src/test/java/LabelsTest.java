import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelsTest {

    //подход 'автотесты как документация'
    @Test
    @Feature("Issue")
    @Story("Создание Issue")
    @Owner("dardorsh")
    @DisplayName("Создание Issue для пользователя")
    public void testStaticLabels() {
        //some code
    }
}
