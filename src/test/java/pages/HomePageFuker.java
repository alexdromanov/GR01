package pages;

import com.github.javafaker.Faker;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class HomePageFuker {
    Faker faker = new Faker();

    String name = faker.name().firstName(),
            surname = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            phone = faker.number().digits(10),
            subject = "English",
            address = faker.address().streetAddress(),
            state = "NCR",
            city = "Delhi";

    public void openPage() {
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
    }

    public void fillData() {
        $("#firstName").val(name);
        $("#lastName").val(surname);
        $("#userEmail").val(email);
        $(byText("Male")).click();
        $(byText("Female")).click();
        $(byText("Other")).click();
        $("#userNumber").val(phone);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("0");
        $(".react-datepicker__year-select").selectOptionByValue("1910");
        $(".react-datepicker__day--003").click();
        $("#subjectsInput").val(subject).pressEnter();
        $(byText("Sports")).click();
        $(byText("Reading")).click();
        $(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("11.jpg");
        $("#currentAddress").val(address);
        $("#react-select-3-input").val(state).pressEnter();
        $("#react-select-4-input").val(city).pressEnter();
        $("#submit").click();
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

    }

    public void checkData() {
        $(".modal-content").shouldHave(
                text(name),
                text(surname),
                text(email),
                text("Other"),
                text(phone),
                text("03 January,1910"),
                text(subject),
                text("Sports, Reading, Music"),
                text("11.jpg"),
                text(address),
                text(state),
                text(city)
        );
    }
}
