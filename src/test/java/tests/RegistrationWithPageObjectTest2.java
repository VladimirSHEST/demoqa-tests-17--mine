package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static utils.RandomUtils.randomString;

public class RegistrationWithPageObjectTest2 extends TestBase{
    @Test
    void FillFormTest() {
        String userName = randomString(10);
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
