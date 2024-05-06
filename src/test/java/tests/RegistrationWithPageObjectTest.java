package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

public class RegistrationWithPageObjectTest extends TestBase {

    @Test
    void FillFormTest() {
        String userName = "Vova";
        Configuration.pageLoadTimeout = 55000;

        registrationPage.openPage().setFirstNameInpun(userName)
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
