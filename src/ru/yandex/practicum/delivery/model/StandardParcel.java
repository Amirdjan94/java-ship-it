package ru.yandex.practicum.delivery.model;

import ru.yandex.practicum.delivery.data.ParcelData;

public class StandardParcel extends Parcel {

    public StandardParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
        System.out.println("Создана стандартная посылка");
    }

    @Override
    public int calculateDeliveryCost() {
        return weight*ParcelData.STANDARD_PARCEL.getBaseCostDelivery();
    }
}
