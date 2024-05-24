package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;


public class GoogleTest {
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    @BeforeAll
    static void beForeAll() {
//        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "chrome";
        Configuration.browserVersion = "100.0";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }
    @BeforeEach
    void addListener(){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }
    @AfterEach
    void addAttachments(){
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();

    }

    @Test
    @Tag("remote")
    void openGoogle(){
        step("Открываем сайт", () -> {
            open("https://www.google.ru/?hl=ru");
        });
        step("Проверка", () -> {
            $("body").shouldHave(text("Google"));
        });
        open("https://www.google.ru/?hl=ru");
        open("https://vk.com/");
        open("https://www.google.ru/?hl=ru");
        open("https://www.google.ru/?hl=ru");
        open("https://vk.com/");
        open("https://www.google.ru/?hl=ru");
        open("https://www.google.ru/?hl=ru");
    }
    @Test
    @Tag("remote")
    public void testLambdaStep(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.holdBrowserOpen = true;

        step("открываем главную страницу ", () -> {
            open("https://github.com/");
        });
        // тоже самое без лямбды
//        step("открываем главную страницу ", new Allure.ThrowableRunnableVoid() {
//            @Override
//            public void run() throws Throwable {
//                open("https://github.com/");
//            }
//        });
//        $(withText("#87")).should(Condition.exist);
        step("ищем репозиторий " + REPOSITORY, () ->{
            $("[data-target='qbsearch-input.inputButtonText']").click();
            $("[name='query-builder-test']").sendKeys(REPOSITORY);
            $("[name='query-builder-test']").submit();
        });
        step("Кликаем по ссылке репозитория " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Открываем вкладку issues ", () -> {
            $("#issues-tab").click();
        });
        step("Проверка наличия issue с номером 87 ", () -> {
            $(withText("#87")).should(Condition.exist);
        });
    }
}
