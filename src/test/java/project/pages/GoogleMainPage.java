package project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class GoogleMainPage extends PageBase {

    @FindBy(name = "q")
    private WebElement SearchInput;

    @FindBy(css = "div[role='presentation']")
    private WebElement CalcInput;

    @FindBy(id = "cwos")
    private WebElement CalcResult;

    @FindBy(xpath = "//div/span[@aria-label=\"история вычислений\"]/following::div/div/span")
    private WebElement CalcHistory;

    @FindBy(css = "input[value=\"Поиск в Google\"]")
    private WebElement SearchButton;

    /**
     * Конструктор класса
     * @param driver инстанс драйвера
     */
    public GoogleMainPage(WebDriver driver) {
        super(driver);
    }

    public GoogleMainPage open() {
        driver.navigate().to("https://www.google.ru/");
        return this;
    }

    public GoogleMainPage sendText(String text){
        SearchInput.sendKeys(text);
        SearchButton.click();
        return this;
    }

    public GoogleMainPage sendForm(String text){
        CalcInput.sendKeys(text);
        return this;
    }

    public GoogleMainPage asserResult(String result) {
        String test = CalcResult.getText();
        Assert.assertEquals(test, result, "Не сходится");
        return this;
    }

    public GoogleMainPage assertForm(String form) {
        Assert.assertEquals(CalcHistory.getText(), form, "Не сходится");
        return this;
    }
}
