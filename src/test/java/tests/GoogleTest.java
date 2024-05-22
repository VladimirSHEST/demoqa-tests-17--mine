package tests;

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
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;


public class GoogleTest {
    @BeforeAll
    static void beForeAll() {
//        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "firefox";
        Configuration.browserVersion = "122.0";
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
    }
//
//    @Test
//    @Tag("remote")
//    void FillFormTest() {
//
//        String userName = "Vova";
//        Configuration.pageLoadTimeout = 55000;
//
//        open("https://demoqa.com/automation-practice-form");
//        $(".text-center").shouldHave(text("Practice Form"));
//
//        $x("//input[@placeholder='First Name']").setValue(userName);
//        $x("//input[@placeholder='Last Name']").setValue("Shest");
//        $x("//input[@id='userEmail']").setValue("piterskiyvv@mail.ru");
//        $x("//label[@for='gender-radio-1']").click(); // гендер
//        $x("//input[@placeholder='Mobile Number']").setValue("1234567890");  // номер
//        $x("//input[@id='subjectsInput']").setValue("Maths").pressEnter();  // предметы
//        $x("//label[@for='hobbies-checkbox-1']").click();  // хобби
//        $x("//textarea[@placeholder='Current Address']").setValue("Samara");   // адрес
//
//        $x("//input[@id='dateOfBirthInput']").click();
//        $x("//select[@class='react-datepicker__year-select']").click();
//        $x("//option[@value='1989']").click();
//        $x("//select[@class='react-datepicker__month-select']").click();
//        $x("//option[@value='5']").click();
//        $x("//div[@class='react-datepicker__day react-datepicker__day--019']").click();
//
////      штат и город
//        $x("//div[@class=' css-1wa3eu0-placeholder']").click();  // клик по кнопке для выпадения
//        $("#stateCity-wrapper").$(byText("NCR")).click();   // клик по тексту через общий див
////        $x("(//div[@class=' css-tlfecz-indicatorContainer'])[1]").click();  // как искать через массив элементов?
////        $x("//div[@id='react-select-3-option-2']").click();
//        $x("//div[text()='Select City']").click();  // клик по кнопке для выпадения
//        $x("//div[@id='react-select-4-option-2']").click();   // поиск элемента через заморозку
//
//        // вставка файла
//        $x("//input[@id='uploadPicture']").uploadFromClasspath("img/1.png");
//
//        $("#submit").click();     // утверждение
//
//        $(".modal-content").should(appear); // перевод-элемент должен появиться
//        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));  // проверка появления формы
//
//        $(".table-responsive").shouldHave(text(userName),text("Shest"),text("piterskiyvv@mail.ru"));  //  проверка заполнения таблицы
//    }
}
