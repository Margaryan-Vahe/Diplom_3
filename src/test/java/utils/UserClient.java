package utils;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserClient {
    private static final String BASE = "https://stellarburgers.nomoreparties.site/api";

    @Step("API: регистрация пользователя {user.email}")
    public Response register(User user) {
        return given()
                .header("Content-Type", "application/json")
                .body(user)
                .when()
                .post(BASE + "/auth/register");
    }

    @Step("API: логин пользователя {user.email}")
    public Response login(User user) {
        return given()
                .header("Content-Type", "application/json")
                .body(user)
                .when()
                .post(BASE + "/auth/login");
    }

    @Step("API: удалить пользователя по токену")
    public void delete(String accessToken) {
        given()
                .header("Authorization", accessToken)
                .when()
                .delete(BASE + "/auth/user");
    }
}
