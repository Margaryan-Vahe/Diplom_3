package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class RegisterPage {

    private final SelenideElement formRoot =
            $x("//div[@class='Auth_login__3hAey']/h2");

    private final SelenideElement inputName = $x("(//input[@name='name' or @type='text'])[1]");
    private final SelenideElement inputEmail = $x("(//input[@name='name' or @type='text'])[2]");
    private final SelenideElement inputPassword = $x("//input[@name='password' or @type='password']");
    private final SelenideElement btnRegister = $x("//button[normalize-space()='Зарегистрироваться']");
    private final SelenideElement errPassword = $x("//p[contains(@class,'input__error')]");

    @Step("Регистрация: дождаться формы")
    public void waitOpened() {
        formRoot.shouldBe(visible);
    }

    @Step("Регистрация: заполнить форму (name={name}, email={email}) и отправить")
    public void register(String name, String email, String password) {
        waitOpened();
        inputName.setValue(name);
        inputEmail.setValue(email);
        inputPassword.setValue(password);
        btnRegister.click();
    }

    @Step("Регистрация: проверить сообщение об ошибке пароля")
    public void shouldSeePasswordError() {
        errPassword.shouldBe(visible).shouldHave(text("Некорректный пароль"));
    }

    @Step("Регистрация: перейти к форме входа")
    public void goToLogin() {
        $x("//a[normalize-space()='Войти']").shouldBe(visible).click();
    }
}
