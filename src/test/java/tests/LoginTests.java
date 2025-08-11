package tests;

import com.codeborne.selenide.Selenide;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.ForgotPasswordPage;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;
import utils.BaseTest;
import utils.TestData;
import utils.User;
import utils.UserClient;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTests extends BaseTest {

    @BeforeEach
    public void createUserViaApi() {
        testUserEmail = TestData.uniqEmail();
        testUserPassword = TestData.password(8);
        String name = TestData.name();

        Response r = new UserClient().register(new User(testUserEmail, testUserPassword, name));
        assertTrue(r.statusCode() == 200 || r.statusCode() == 201, "Регистрация через API должна быть успешной");
        testUserAccessToken = r.then().extract().path("accessToken");
        Selenide.clearBrowserCookies();
    }

    @Test
    @DisplayName("Вход: по кнопке 'Войти в аккаунт' на главной")
    public void loginFromMainButton() {
        new MainPage().clickLoginOnMain();
        new LoginPage().login(testUserEmail, testUserPassword);

        new MainPage().shouldBeLoggedIn();
    }

    @Test
    @DisplayName("Вход: через кнопку 'Личный Кабинет'")
    public void loginFromAccountButton() {
        new MainPage().goToAccount();
        new LoginPage().login(testUserEmail, testUserPassword);

        new MainPage().shouldBeLoggedIn();
    }

    @Test
    @DisplayName("Вход: через кнопку в форме регистрации")
    public void loginFromRegisterForm() {
        new MainPage().clickLoginOnMain();
        new LoginPage().goToRegister();

        new RegisterPage().goToLogin();
        new LoginPage().login(testUserEmail, testUserPassword);

        new MainPage().shouldBeLoggedIn();
    }

    @Test
    @DisplayName("Вход: через кнопку в форме восстановления пароля")
    public void loginFromForgotPasswordForm() {
        new MainPage().clickLoginOnMain();
        new LoginPage().goToForgot();

        new ForgotPasswordPage().goToLogin();
        new LoginPage().login(testUserEmail, testUserPassword);

        new MainPage().shouldBeLoggedIn();
    }
}
