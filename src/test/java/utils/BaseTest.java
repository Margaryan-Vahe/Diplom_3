package utils;

import com.codeborne.selenide.WebDriverRunner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;
import io.restassured.response.Response;

public abstract class BaseTest {
    protected static final String BASE_URL = "https://stellarburgers.nomoreparties.site/";

    protected String testUserEmail;
    protected String testUserPassword;
    protected String testUserAccessToken;


    @BeforeEach
    public void setUp() {
        String browserName = System.getProperty("browser", "chrome");
        WebDriverRunner.setWebDriver(new Browser().getWebDriver(browserName));
        open(BASE_URL);
    }

    @AfterEach
    public void tearDown() {
        try {
            if (testUserAccessToken != null || (testUserEmail != null && testUserPassword != null)) {
                UserClient api = new UserClient();
                String token = testUserAccessToken;

                if (token == null) {
                    Response login = api.login(new User(testUserEmail, testUserPassword, null));
                    if (login.statusCode() == 200 || login.statusCode() == 201) {
                        token = login.then().extract().path("accessToken");
                    }
                }

                if (token != null) {
                    api.delete(token);
                }
            }
        } finally {
            clearBrowserCookies();
            closeWebDriver();
        }
    }
}