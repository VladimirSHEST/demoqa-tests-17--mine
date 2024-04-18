package tests;

import com.codeborne.selenide.Configuration;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationWithPageObjectTest extends TestBase {


    @Test
    void FillFormTest() {
        String userName = "Vova";
        Configuration.pageLoadTimeout = 45000;

        registrationPage.openPage().setFirstName(userName)
                .setLastName("Shest").setEmail("piterskiyvv@mail.ru")
                .setGender().setNumber("1234567890").setBirthDay();


        $x("//input[@id='subjectsInput']").setValue("Maths").pressEnter();  // предметы
        $x("//label[@for='hobbies-checkbox-1']").click();  // хобби
        $x("//textarea[@placeholder='Current Address']").setValue("Samara");   // адрес

//      штат и город
        $x("//div[@class=' css-1wa3eu0-placeholder']").click();  // клик по кнопке для выпадения
        $("#stateCity-wrapper").$(byText("NCR")).click();   // клик по тексту через общий див
//        $x("(//div[@class=' css-tlfecz-indicatorContainer'])[1]").click();  // как искать через массив элементов?
//        $x("//div[@id='react-select-3-option-2']").click();
        $x("//div[text()='Select City']").click();  // клик по кнопке для выпадения
        $x("//div[@id='react-select-4-option-2']").click();   // поиск элемента через заморозку

        // вставка файла
        $x("//input[@id='uploadPicture']").uploadFromClasspath("img/1.png");

        $("#submit").click();     // рассмотрение

        registrationPage.verifyResultsModalAppear()
                .verifyResult("Student Name","Vova Shest")
                .verifyResult("Student Email","piterskiyvv@mail.ru")
                .verifyResult("Subjects","Maths")
                .verifyResult("Address","Samara");





        $(".table-responsive").shouldHave(text(userName), text("Shest"), text("piterskiyvv@mail.ru"));  //  проверка заполнения таблицы
    }

}
