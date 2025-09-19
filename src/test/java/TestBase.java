import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;


public class TestBase {

    @BeforeEach
    void setup() {
        Configuration.browser = "chrome";
        Configuration.pageLoadStrategy = "normal";

        SelenideLogger.addListener("allure", new AllureSelenide());
    }
}
