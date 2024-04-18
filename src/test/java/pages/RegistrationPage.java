package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    public  RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    private final String TITLE_TEXT = "Practice Form";

    private SelenideElement
            lastNameInput = $x("//input[@placeholder='Last Name']"),
            firstName = $x("//input[@placeholder='First Name']");


    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".text-center").shouldHave(text(TITLE_TEXT));
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstName.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage clearLastName() {
        lastNameInput.clear();
        return this;
    }

    public RegistrationPage setEmail(String value) {
        $x("//input[@id='userEmail']").setValue(value);
        return this;
    }

    public RegistrationPage setGender() {
        $x("//label[@for='gender-radio-1']").click();
        return this;
    }

    public RegistrationPage setNumber(String value) {
        $x("//input[@placeholder='Mobile Number']").setValue(value);
        return this;
    }

    public RegistrationPage setBirthDay() {
        $x("//input[@id='dateOfBirthInput']").click();
        calendarComponent.setDate();
        return this;
    }

    public RegistrationPage verifyResultsModalAppear() {
        registrationResultsModal.verifyModalAppear();
        return this;
    }    public RegistrationPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);
        return this;
    }


}
