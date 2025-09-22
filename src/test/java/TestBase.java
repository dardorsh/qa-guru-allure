import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;


public class TestBase {


    @BeforeAll
    void setupBeforeAll() {
        Configuration.browser = "chrome";
        Configuration.pageLoadStrategy = "normal";
    }
    @BeforeEach
    void setupBeforeEach() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }
}
