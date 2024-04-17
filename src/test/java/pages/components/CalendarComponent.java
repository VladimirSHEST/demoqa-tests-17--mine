package pages.components;

import static com.codeborne.selenide.Selenide.$x;

public class CalendarComponent {
    public void setDate(){

        $x("//select[@class='react-datepicker__year-select']").click();
        $x("//option[@value='1989']").click();
        $x("//select[@class='react-datepicker__month-select']").click();
        $x("//option[@value='5']").click();
        $x("//div[@class='react-datepicker__day react-datepicker__day--019']").click();

    }
}
