package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    private final SelenideElement titleLogin =
            $x("//h2[normalize-space()='Вход']");
    private final SelenideElement inputEmail =
            $x("(//input[@class='text input__textfield text_type_main-default'])[1]");
    private final SelenideElement inputPassword =
            $x("(//input[@class='text input__textfield text_type_main-default'])[2]");
    private final SelenideElement btnLogin =
            $x("//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");
    private final SelenideElement linkRegister =
            $x("//a[normalize-space()='Зарегистрироваться']");
    private final SelenideElement linkForgot =
            $x("//a[normalize-space()='Восстановить пароль']");

    @Step("Вход: дождаться открытия формы")
    public void waitOpened() {
        titleLogin.shouldBe(visible);
    }

    @Step("Вход: авторизация email={email}")
    public void login(String email, String password) {
        waitOpened();
        inputEmail.setValue(email);
        inputPassword.setValue(password);
        btnLogin.click();
    }

    @Step("Вход: перейти на форму регистрации")
    public void goToRegister() {
        linkRegister.shouldBe(visible).click();
    }

    @Step("Вход: перейти на форму восстановления пароля")
    public void goToForgot() {
        linkForgot.shouldBe(visible).click();
    }
}
