package ru.yandex.practicum.delivery.data;

public enum ParcelData {
    FRAGILE_PARCEL(4, "Хрупкая посылка"),
    PERISHABLE_PARCEL(3, "Скоропортящаяся посылка"),
    STANDARD_PARCEL(2, "Стандартная посылка");

    private int baseCostDelivery;
    private String typeOfParcel;

    ParcelData(int baseCostDelivery, String typeOfParcel) {
        this.baseCostDelivery = baseCostDelivery;
        this.typeOfParcel = typeOfParcel;
    }

    public int getBaseCostDelivery() {
        return baseCostDelivery;
    }

    public String getTypeOfParcel() {
        return typeOfParcel;
    }
}
