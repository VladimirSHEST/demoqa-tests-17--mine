package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private final String TITLE_TEXT = "Practice Form";

    private SelenideElement
            lastNameInput = $x("//input[@placeholder='Last Name']"),
            firstName = $x("//input[@placeholder='First Name']");


    public void openPage() {
        open("/automation-practice-form");
        $(".text-center").shouldHave(text(TITLE_TEXT));

    }

    public void setFirstName(String value) {
        firstName.setValue(value);
    }

    public void setLastName(String value) {
        lastNameInput.setValue(value);
    }

    public void clearLastName() {
        lastNameInput.clear();
    }

    public void setEmail(String value) {
        $x("//input[@id='userEmail']").setValue(value);
    }

    public void setGender(String value) {
        $x(value).click();
    }

    public void setNumber(String value) {
        $x("//input[@placeholder='Mobile Number']").setValue(value);
    }
}
