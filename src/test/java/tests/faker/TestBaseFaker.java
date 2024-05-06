package tests.faker;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import pages.RegistrationPage;

public class TestBaseFaker {

    public Faker faker = new Faker();
    public String name = faker.name().fullName(); //
    public String firstNameFaker = faker.name().firstName(); //
    public String lastName = faker.name().lastName(); //
    public String userEmail = faker.internet().emailAddress();



    RegistrationPageForFaker registrationPageForFaker = new RegistrationPageForFaker();

    @BeforeAll
    static void beForeAll() {
        Configuration.holdBrowserOpen = true;
//        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }
}
