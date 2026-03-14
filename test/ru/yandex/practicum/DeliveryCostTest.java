package ru.yandex.practicum;

import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.model.FragileParcel;
import ru.yandex.practicum.delivery.model.PerishableParcel;
import ru.yandex.practicum.delivery.model.StandardParcel;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeliveryCostTest {

    private final String DESCRIPTION = "Описание";
    private final int WEIGHT = 5;
    private final String DELIVERY_ADDRESS = "Москва";
    private final int SEND_DAY = 22;
    private final int TIME_TO_LIVE = 30;

    @Test
    public void shouldCorrectlyCalculatedDeliveryCostForStandardParcel() {
        StandardParcel standardParcel = new StandardParcel(DESCRIPTION, WEIGHT, DELIVERY_ADDRESS, SEND_DAY);

        assertEquals(10, standardParcel.calculateDeliveryCost(), "Не правильный подсчет стоимости доставки стандартных посылок");
    }

    @Test
    public void shouldCorrectlyCalculatedDeliveryCostForPerishableParcel() {
        PerishableParcel perishableParcel = new PerishableParcel(DESCRIPTION, WEIGHT, DELIVERY_ADDRESS, SEND_DAY, TIME_TO_LIVE);

        assertEquals(15, perishableParcel.calculateDeliveryCost(), "Не правильный подсчет стоимости доставки скоропортящихся посылок");
    }

    @Test
    public void shouldCorrectlyCalculatedDeliveryCostForFragileParcel() {
        FragileParcel fragileParcel = new FragileParcel(DESCRIPTION, WEIGHT, DELIVERY_ADDRESS, SEND_DAY);

        assertEquals(20, fragileParcel.calculateDeliveryCost(), "Не правильный подсчет стоимости доставки хрупких посылок");
    }
}
