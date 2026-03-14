package ru.yandex.practicum;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.model.ParcelBox;
import ru.yandex.practicum.delivery.model.PerishableParcel;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParcelBoxTest {
    public static PerishableParcel perishableParcel;
    public ParcelBox<PerishableParcel> parcelBox;

    private static final String DESCRIPTION = "Описание";
    private static final int WEIGHT = 5;
    private static final String DELIVERY_ADDRESS = "Москва";
    private static final int SEND_DAY = 22;
    private static final int TIME_TO_LIVE = 5;
    private static final int MAX_WEGHT_IS_GREATER_THAN_CURRENT = 6;
    private static final int MAX_WEGHT_IS_EQUAL_THAN_CURRENT = 5;
    private static final int MAX_WEGHT_IS_LESS_THAN_CURRENT = 4;

    @BeforeAll
    public static void generationParcelAndBox() {
        perishableParcel = new PerishableParcel(DESCRIPTION, WEIGHT, DELIVERY_ADDRESS, SEND_DAY, TIME_TO_LIVE);
    }

    @Test
    public void shouldParcelBoxMaxWeightIsGreaterThanCurrentParcelAddBox() {
        parcelBox = new ParcelBox<>(MAX_WEGHT_IS_GREATER_THAN_CURRENT);
        assertTrue(parcelBox.addParcel(perishableParcel), "Посылка должна быть добавлена в коробку");
    }

    @Test
    public void shouldParcelBoxMaxWeightIsEqualThanCurrentParcelAddBox() {
        parcelBox = new ParcelBox<>(MAX_WEGHT_IS_EQUAL_THAN_CURRENT);
        assertTrue(parcelBox.addParcel(perishableParcel), "Посылка должна быть добавлена в коробку");
    }

    @Test
    public void shouldParcelBoxMaxWeightIsLessThanCurrentParcelNotAddBox() {
        parcelBox = new ParcelBox<>(MAX_WEGHT_IS_LESS_THAN_CURRENT);
        assertFalse(parcelBox.addParcel(perishableParcel), "Посылка должна быть НЕ добавлена в коробку");
    }
}
