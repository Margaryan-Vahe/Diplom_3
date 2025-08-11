package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;
import utils.BaseTest;
import utils.TestData;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class RegistrationTests extends BaseTest {

    @Test
    @DisplayName("Регистрация: успешная регистрация нового пользователя")
    public void successfulRegistration() {
        new MainPage().clickLoginOnMain();
        new LoginPage().goToRegister();

        testUserEmail = TestData.uniqEmail();
        testUserPassword = TestData.password(8);
        String name = TestData.name();

        new RegisterPage().register(name, testUserEmail, testUserPassword);

        new LoginPage().waitOpened();
    }

    @Test
    @DisplayName("Регистрация: ошибка при пароле короче 6 символов")
    public void registrationShortPasswordError() {
        new MainPage().clickLoginOnMain();
        new LoginPage().goToRegister();

        new RegisterPage().register(TestData.name(), TestData.uniqEmail(), TestData.password(5));
        new RegisterPage().shouldSeePasswordError();
    }
}
