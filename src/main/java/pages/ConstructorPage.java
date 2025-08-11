package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.attributeMatching;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class ConstructorPage {

    private final SelenideElement tabBuns = $x("//span[normalize-space()='Булки']");
    private final SelenideElement tabSauces = $x("//span[normalize-space()='Соусы']");
    private final SelenideElement tabFillings = $x("//span[normalize-space()='Начинки']");

    @Step("Конструктор: открыть вкладку 'Булки' и проверить, что она активна")
    public void openBuns() {
        tabSauces.shouldBe(visible).click();
        tabBuns.shouldBe(visible).click();
        tabBuns.parent().shouldHave(attributeMatching("class", ".*current.*"));
    }

    @Step("Конструктор: открыть вкладку 'Соусы' и проверить, что она активна")
    public void openSauces() {
        tabSauces.shouldBe(visible).click();
        tabSauces.parent().shouldHave(attributeMatching("class", ".*current.*"));
    }

    @Step("Конструктор: открыть вкладку 'Начинки' и проверить, что она активна")
    public void openFillings() {
        tabFillings.shouldBe(visible).click();
        tabFillings.parent().shouldHave(attributeMatching("class", ".*current.*"));
    }
}
