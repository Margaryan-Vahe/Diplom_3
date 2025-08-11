package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class AccountPage {

    private final SelenideElement btnLogout =
            $x("//button[normalize-space()='Выход']");
    private final SelenideElement linkConstructorTop =
            $x("//p[normalize-space()='Конструктор']");
    private final SelenideElement logo =
            $x("//header//a[contains(@href,'/')]");

    @Step("Личный кабинет: дождаться открытия")
    public void waitOpened() {
        btnLogout.shouldBe(visible);
    }

    @Step("Личный кабинет: перейти в 'Конструктор' по кнопке")
    public void goToConstructorByButton() {
        linkConstructorTop.shouldBe(visible).click();
    }

    @Step("Личный кабинет: перейти в 'Конструктор' по логотипу")
    public void goToConstructorByLogo() {
        logo.shouldBe(visible).click();
    }
    @Step("Личный кабинет: выйти из аккаунта")
    public void logout() {
        btnLogout.shouldBe(visible).click();
    }
}
