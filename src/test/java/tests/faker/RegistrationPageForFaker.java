package tests.faker;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPageForFaker {

    CalendarComponent calendarComponent = new CalendarComponent();
    public RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    private final String TITLE_TEXT = "Practice Form";

    private SelenideElement
            lastNameInput = $x("//input[@placeholder='Last Name']"),
            firstNameInpun = $x("//input[@placeholder='First Name']");


    public RegistrationPageForFaker openPage() {
        open("/automation-practice-form");
        $(".text-center").shouldHave(text(TITLE_TEXT));
        return this;
    }

    public RegistrationPageForFaker setFirstNameInpun(String value) {
        firstNameInpun.setValue(value);
        return this;
    }

    public RegistrationPageForFaker setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPageForFaker clearLastName() {
        lastNameInput.clear();
        return this;
    }

    public RegistrationPageForFaker setEmail(String value) {
        $x("//input[@id='userEmail']").setValue(value);
        return this;
    }

    public RegistrationPageForFaker setGender() {
        $x("//label[@for='gender-radio-1']").click();
        return this;
    }

    public RegistrationPageForFaker setNumber(String value) {
        $x("//input[@placeholder='Mobile Number']").setValue(value);
        return this;
    }

    public RegistrationPageForFaker setBirthDay() {
        $x("//input[@id='dateOfBirthInput']").click();
        calendarComponent.setDate();
        return this;
    }

    public RegistrationPageForFaker setSubject() {    // хобби
        $x("//input[@id='subjectsInput']").setValue("Maths").pressEnter();
        return this;
    }

    public RegistrationPageForFaker setHobbies() {
        $x("//label[@for='hobbies-checkbox-1']").click();
        return this;
    }

    public RegistrationPageForFaker setAddress() {     // адрес
        $x("//textarea[@placeholder='Current Address']").setValue("Samara");
        return this;
    }

    public RegistrationPageForFaker setCity() {     //  штат и город
//        $x("//div[@class=' css-1wa3eu0-placeholder']").click();  // клик по кнопке для выпадения
//        $("#stateCity-wrapper").$(byText("NCR")).click();   // клик по тексту через общий див
//        $x("//div[text()='Select City']").click();  // клик по кнопке для выпадения
//        $x("//div[@id='react-select-4-option-2']").click();   // поиск элемента через заморозку
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
        return this;
    }

    public RegistrationPageForFaker setUploadPicture() {    // вставка файла
        $x("//input[@id='uploadPicture']").uploadFromClasspath("img/1.png");
        return this;
    }

    public RegistrationPageForFaker setSubmit() {  // рассмотрение
        $("#submit").click();
        return this;
    }


    public RegistrationPageForFaker verifyResultsModalAppear() {
        registrationResultsModal.verifyModalAppear();
        return this;
    }

    public RegistrationPageForFaker verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);
        return this;
    }

    public void verifyTable(String name) {    //  проверка заполнения таблицы
        $(".table-responsive").shouldHave(text(name), text("Shest"), text("piterskiyvv@mail.ru"));
    }
}
