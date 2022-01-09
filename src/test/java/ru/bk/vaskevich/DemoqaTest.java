package ru.bk.vaskevich;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoqaTest {

   @Test
    void test() {
       open("https://demoqa.com/automation-practice-form");
       $("#firstName").setValue("Svetlana");
       $("#lastName").setValue("Ivanova");
       $("#userEmail").setValue("mymail@bk.ru");
       $(byText("Female")).click();
       $("#userNumber").setValue("8999456123");
       $("#dateOfBirthInput").click();
       $(".react-datepicker__month-select").click();
       $(".react-datepicker__month-select").selectOption("December");
       $(".react-datepicker__year-select").selectOption("1987");
       $(".react-datepicker__day.react-datepicker__day--023").click();
       $("#subjectsInput").setValue("English").pressEnter();
       $(byText("Sports")).click();
       $("#uploadPicture").uploadFromClasspath("image\\sport1.png");
       $("#currentAddress").setValue("Russia,Ekaterinburg").scrollTo();
       $("#state").click();
       $("#stateCity-wrapper").$(byText("NCR")).click();
       $("#city").click();
       $("#stateCity-wrapper").$(byText("Noida")).click();
       $("#submit").click();
       $(".table-responsive").shouldHave(text("Svetlana Ivanova"),text("mymail@bk.ru"),
       text("Female"),text("23 December,1987"),text("English"),text("Sports"),text("sport1.png"),
       text("Russia,Ekaterinburg"),text("NCR Noida"));
   }
}
