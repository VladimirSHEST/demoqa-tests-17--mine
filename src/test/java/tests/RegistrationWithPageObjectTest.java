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
                .setGender().setNumber("1234567890").setBirthDay().setSubject()
                .setHobbies().setAddress().setCity().setUploadPicture()
                .setSubmit();

        registrationPage.verifyResultsModalAppear()
                .verifyResult("Student Name", "Vova Shest")
                .verifyResult("Student Email", "piterskiyvv@mail.ru")
                .verifyResult("Subjects", "Maths")
                .verifyResult("Address", "Samara").setCity();

        registrationPage.verifyTable();
    }

}
