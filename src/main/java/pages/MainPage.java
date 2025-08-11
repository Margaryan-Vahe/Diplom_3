package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    private final SelenideElement loginButton =
            $x("//button[normalize-space()='Войти в аккаунт']");
    private final SelenideElement linkAccount =
            $x("//p[contains(normalize-space(.),'Личный') and contains(normalize-space(.),'Кабинет')]");
    private final SelenideElement btnOrder =
            $x("//button[normalize-space()='Оформить заказ']");
    private final SelenideElement headerConstructor =
            $x("//h1[normalize-space()='Соберите бургер']");

    @Step("Главная: клик по кнопке 'Войти в аккаунт'")
    public void clickLoginOnMain() {
        loginButton.shouldBe(visible).click();
    }

    @Step("Главная: клик по кнопке 'Личный Кабинет'")
    public void goToAccount() {
        linkAccount.shouldBe(visible).click();
    }
    @Step("Главная: проверить, что пользователь авторизован (кнопка 'Оформить заказ' видна)")
    public void shouldBeLoggedIn() {
        btnOrder.shouldBe(visible);
    }
    @Step("Главная: дождаться открытия конструктора")
    public void waitConstructorOpened() {
        headerConstructor.shouldBe(visible);
    }
}
