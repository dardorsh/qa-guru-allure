import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.attachment;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.partialLinkText;

public class AttachmentsTest {

    private static final String REPOSITORY = "dardorsh/298063-technomart-28";
    private static final int ISSUE = 1;

    @Test
    void issueSearchTestWithLambdaStepsAndAttachments() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open("https://github.com");
            attachment("Source", webdriver().driver().source());
        });
        step("Ищем репозиторий " + REPOSITORY, () -> {
            $("[data-target='qbsearch-input.inputButton']").click();
            $("[data-target='query-builder.input']").setValue(REPOSITORY).pressEnter();
        });
        step("Кликаем по ссылке репозитория " + REPOSITORY,
                () -> $(partialLinkText(REPOSITORY)).click());
        step("Открывает таб Issues",
                () -> $("#issues-tab").click());
        step("Проверяем наличие Issue с номером " + ISSUE,
                () -> $(withText("#" + ISSUE)).should(exist));
    }

    @Test
    public void searchIssueWithAnnotatedStepsAndAttachments() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepositoryLink(REPOSITORY);
        steps.openIssuesTab();
        steps.shouldSeeIssueWithNumber(ISSUE);
        steps.takeScreenshot();
    }
}
