package ru.yandex.practicum.delivery.model;

import ru.yandex.practicum.delivery.data.ParcelData;

public class FragileParcel extends Parcel implements Trackable {

    public FragileParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
        System.out.println("Создана хрупкая посылка");
    }

    @Override
    public void packageItem() {
        System.out.println("Посылка <<" + description + ">> обёрнута в защитную плёнку");
        System.out.println("Посылка <<" + description + ">> упакована");
    }

    @Override
    public int calculateDeliveryCost() {
        return weight*ParcelData.FRAGILE_PARCEL.getBaseCostDelivery();
    }

    @Override
    public void reportStatus(String newLocation) {
        System.out.println("Хрупкая посылка <<" + description + ">> изменила местоположение на " + newLocation);
    }
}
