package ru.yandex.practicum.delivery.model;

import ru.yandex.practicum.delivery.DeliveryApp;

import java.util.ArrayList;
import java.util.List;

public class ParcelBox<T extends Parcel> {
    private final int maxWeight;
    private int currentWeight = 0;
    private List<T> boxList = new ArrayList<>();

    public ParcelBox(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public void addParcel(T parcel) {
        if ((currentWeight + parcel.weight) <= maxWeight) {
            boxList.add(parcel);
            System.out.println("Посылка успешно добавлена в коробку");
            DeliveryApp.printDivide();
        } else {
            System.out.println("Превышен максимальный вес посылок в коробке, посылка не добавлена, выберете другую коробку");
            DeliveryApp.printDivide();
        }
    }

    public void getAllParcels() {
        System.out.println("Список посылок в коробке:");
        for (T t : boxList) {
            System.out.println(t.description);
        }
    }
}
