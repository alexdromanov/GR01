package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomePage {

    SelenideElement inputFirstName =  $("#firstName");
    SelenideElement inputLastName =  $("#lastName");
    SelenideElement inputUserEmail =  $("#userEmail");
    SelenideElement inputUserNumber =  $("#userNumber");

    public HomePage openSite(){
        open("https://demoqa.com/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));
        return this;
    }

    public HomePage packFirstBlock(String firstName,String lastName, String userEmail, String userNumber  ) {

        inputFirstName.setValue(firstName);
        inputLastName.setValue(lastName);
        inputUserEmail.setValue(userEmail);
        inputUserNumber.setValue(userNumber);

        return this;
    }
    public HomePage selectGender(String gender){

        $(byText(gender)).click();



        return this;
    }
//    $("#firstName").setValue(firstName);
//    $("#lastName").setValue(lastName);
//    $("#userEmail").setValue(email);
//    $("#gender-radio-1").doubleClick();
//    $("#userNumber").setValue(phone);

}
