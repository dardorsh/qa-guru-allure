import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.*;

public class SelenideTest extends TestBase {

    private static final String REPOSITORY = "dardorsh/298063-technomart-28";
    private static final int ISSUE = 1;

    @Test
    void testIssueSearchBasic() {
        open("https://github.com");
        $("[data-target='qbsearch-input.inputButton']").click();
        $("[data-target='query-builder.input']").setValue(REPOSITORY).pressEnter();
        $(linkText(REPOSITORY)).click();
        $(withText("#" + ISSUE)).should(exist);
    }
}
