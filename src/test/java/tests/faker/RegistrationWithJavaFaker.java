package tests.faker;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationWithJavaFaker extends TestBase {
    Faker faker = new Faker();
    String name = faker.name().fullName(); //
    String firstName = faker.name().firstName(); //
    String lastName = faker.name().lastName(); //
    String userEmail = faker.internet().emailAddress();

    @Test
    void FillFormTest() {
        Configuration.pageLoadTimeout = 45000;
        open("https://demoqa.com/automation-practice-form");

        // Fill out the form
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $x("//label[@for='gender-radio-1']").click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__day--014").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $x("//label[@for='hobbies-checkbox-1']").click();
        $("#uploadPicture").uploadFromClasspath("img/1.png");
        $("#currentAddress").setValue("123 Main St");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
        $("#submit").click();

        // Verify that the form was submitted successfully
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    }
}


