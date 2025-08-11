package tests;

import com.codeborne.selenide.Selenide;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.AccountPage;
import pages.LoginPage;
import pages.MainPage;
import utils.BaseTest;
import utils.TestData;
import utils.User;
import utils.UserClient;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogoutTests extends BaseTest {

    @BeforeEach
    public void createAndLogin() {
        testUserEmail = TestData.uniqEmail();
        testUserPassword = TestData.password(8);
        String name = TestData.name();

        Response r = new UserClient().register(new User(testUserEmail, testUserPassword, name));
        assertTrue(r.statusCode() == 200 || r.statusCode() == 201, "Регистрация через API должна быть успешной");
        testUserAccessToken = r.then().extract().path("accessToken");
        Selenide.clearBrowserCookies();

        new MainPage().goToAccount();
        new LoginPage().login(testUserEmail, testUserPassword);
        $x("//button[normalize-space()='Оформить заказ']").shouldBe(visible);
    }

    @Test
    @DisplayName("Выход: кнопка 'Выход' в личном кабинете")
    public void logoutFromAccount() {
        new MainPage().goToAccount();
        new AccountPage().logout();

        $x("//h2[normalize-space()='Вход']").shouldBe(visible);
    }
}
