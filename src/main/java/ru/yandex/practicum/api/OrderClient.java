package ru.yandex.practicum.api;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import ru.yandex.practicum.config.ScooterConfig;
import ru.yandex.practicum.entities.Order;
import ru.yandex.practicum.utils.EndPoints;

import static io.restassured.RestAssured.given;

public class OrderClient extends ScooterConfig {

    @Step("Send POST request to /api/v1/orders")
    public ValidatableResponse createOrder(Order order) {
        return given()
                .spec(getBaseSpec())
                .body(order)
                .log().all()
                .post(EndPoints.ORDER_PATH)
                .then()
                .log().all();
    }

}
