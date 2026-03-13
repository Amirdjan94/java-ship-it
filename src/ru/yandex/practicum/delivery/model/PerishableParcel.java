package ru.yandex.practicum.delivery.model;

import ru.yandex.practicum.delivery.data.ParcelData;

public class PerishableParcel extends Parcel {
    int timeToLive;

    public PerishableParcel(String description, int weight, String deliveryAddress, int sendDay, int timeToLive) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
        System.out.println("Создана скоропортящаяся посылка");
    }
    @Override
    public int calculateDeliveryCost() {
        return weight*ParcelData.PERISHABLE_PARCEL.getBaseCostDelivery();
    }

    public boolean isExpired(int currentDay) {
        if ((sendDay + timeToLive) >= currentDay){
            return false;
        } else {
            return true;
        }
    }
}
