package ru.yandex.practicum;

import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.model.FragileParcel;
import ru.yandex.practicum.delivery.model.PerishableParcel;
import ru.yandex.practicum.delivery.model.StandardParcel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PerishableParcelеTest {

    private final String DESCRIPTION = "Описание";
    private final int WEIGHT = 5;
    private final String DELIVERY_ADDRESS = "Москва";
    private final int SEND_DAY = 22;
    private final int TIME_TO_LIVE = 5;

    @Test
    public void isExpiredTest(){
        PerishableParcel perishableParcel = new PerishableParcel(DESCRIPTION, WEIGHT, DELIVERY_ADDRESS, SEND_DAY, TIME_TO_LIVE);

        assertTrue(perishableParcel.isExpired(53));
    }

}
