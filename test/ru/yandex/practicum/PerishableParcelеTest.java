package ru.yandex.practicum;

import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.model.PerishableParcel;

import static org.junit.jupiter.api.Assertions.*;

public class PerishableParcelеTest {

    public static PerishableParcel perishableParcel;

    private static final String DESCRIPTION = "Описание";
    private static final int WEIGHT = 5;
    private static final String DELIVERY_ADDRESS = "Москва";
    private static final int SEND_DAY = 22;
    private static final int TIME_TO_LIVE = 5;

    @BeforeAll
    public static void generationParcel() {
        perishableParcel = new PerishableParcel(DESCRIPTION, WEIGHT, DELIVERY_ADDRESS, SEND_DAY, TIME_TO_LIVE);
    }

    @Test
    public void shouldBeParcelNotExpiredCurrentDate26() {
        assertFalse(perishableParcel.isExpired(26), "Не корректная работа метода isExpired(), продукт должен быть не испорчен");
    }

    @Test
    public void shouldBeParcelNotExpiredCurrentDate27() {
        assertFalse(perishableParcel.isExpired(27), "Не корректная работа метода isExpired(), продукт должен быть не испорчен");
    }

    @Test
    public void shouldBeParcelExpiredCurrentDate28() {
        assertTrue(perishableParcel.isExpired(28), "Не корректная работа метода isExpired(), продукт должен быть испорчен");
    }


}
