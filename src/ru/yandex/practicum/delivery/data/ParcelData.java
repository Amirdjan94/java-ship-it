package ru.yandex.practicum.delivery.data;

public enum ParcelData {
    FRAGILE_PARCEL(4),
    PERISHABLE_PARCEL(3),
    STANDARD_PARCEL(2);

    private int baseCostDelivery;

    ParcelData(int baseCostDelivery) {
        this.baseCostDelivery = baseCostDelivery;
    }

    public int getBaseCostDelivery() {
        return baseCostDelivery;
    }
}
