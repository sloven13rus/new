package project.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import project.pages.GoogleMainPage;

public class Calculator extends TestBase {

    @Test
    public void calculatorTest() {
        new GoogleMainPage(driver)
                .open()
                .sendText("Калькулятор")
                .sendForm("(1 + 2)*3-40/5 =")
                .asserResult("1")
                .assertForm("(1 + 2) × 3 - 40 ÷ 5 =");
    }

    @Test
    public void nullSeveTest() {
        new GoogleMainPage(driver)
                .open()
                .sendText("Калькулятор")
                .sendForm("6 / 0 =")
                .asserResult("Infinity")
                .assertForm("6 ÷ 0 =");
    }

    @Test
    public void sinusTest() {
        new GoogleMainPage(driver)
                .open()
                .sendText("Калькулятор")
                .sendForm("sin =")
                .asserResult("Error")
                .assertForm("sin() =");
    }
}
