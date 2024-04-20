package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    public RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
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

    public RegistrationPage setSubject() {    // хобби
        $x("//input[@id='subjectsInput']").setValue("Maths").pressEnter();
        return this;
    }

    public RegistrationPage setHobbies() {
        $x("//label[@for='hobbies-checkbox-11']").click();
        return this;
    }

    public RegistrationPage setAddress() {     // адрес
        $x("//textarea[@placeholder='Current Address']").setValue("Samara");
        return this;
    }

    public RegistrationPage setCity() {     //штат и город
        $x("//div[@class=' css-1wa3eu0-placeholder']").click();  // клик по кнопке для выпадения
        $("#stateCity-wrapper").$(byText("NCR")).click();   // клик по тексту через общий див
        $x("//div[text()='Select City']").click();  // клик по кнопке для выпадения
        $x("//div[@id='react-select-4-option-2']").click();   // поиск элемента через заморозку
        return this;
    }

    public RegistrationPage setUploadPicture() {    // вставка файла
        $x("//input[@id='uploadPicture']").uploadFromClasspath("img/1.png");
        return this;
    }

    public RegistrationPage setSubmit() {  // рассмотрение
        $("#submit").click();
        return this;
    }


    public RegistrationPage verifyResultsModalAppear() {
        registrationResultsModal.verifyModalAppear();
        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);
        return this;
    }

    public void verifyTable() {    //  проверка заполнения таблицы
        $(".table-responsive").shouldHave(text("Vova"), text("Shest"), text("piterskiyvv@mail.ru"));
    }


}
