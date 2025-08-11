package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class ForgotPasswordPage {

    private final SelenideElement title =
            $x("//h2[normalize-space()='Восстановление пароля']");
    private final SelenideElement linkLogin =
            $x("//a[normalize-space()='Войти']");

    @Step("Восстановление пароля: дождаться открытия")
    public void waitOpened() {
        title.shouldBe(visible);
    }

    @Step("Восстановление пароля: перейти к форме входа")
    public void goToLogin() {
        waitOpened();
        linkLogin.shouldBe(visible).click();
    }
}
