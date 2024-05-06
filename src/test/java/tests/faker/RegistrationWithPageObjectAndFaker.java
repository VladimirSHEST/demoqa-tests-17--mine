package tests.faker;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import static utils.RandomUtils.randomString;

public class RegistrationWithPageObjectAndFaker extends TestBaseFaker{

    @Test
    void FillFormTest() {

        Configuration.pageLoadTimeout = 55000;

        registrationPageForFaker.openPage().setFirstNameInpun(firstNameFaker)
                .setLastName("Shest").setEmail("piterskiyvv@mail.ru")
                .setGender().setNumber("1234567890").setBirthDay().setSubject()
                .setHobbies().setAddress().setCity().setUploadPicture()
                .setSubmit();

        registrationPageForFaker.verifyResultsModalAppear()
                .verifyResult("Student Name", firstNameFaker +" Shest")
                .verifyResult("Student Email", "piterskiyvv@mail.ru")
                .verifyResult("Subjects", "Maths")
                .verifyResult("Address", "Samara").setCity();

        registrationPageForFaker.verifyTable(firstNameFaker);
    }
}
