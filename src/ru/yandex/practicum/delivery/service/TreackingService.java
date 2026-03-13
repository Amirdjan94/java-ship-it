package ru.yandex.practicum.delivery.service;

import ru.yandex.practicum.delivery.model.Trackable;
import java.util.Scanner;
import static ru.yandex.practicum.delivery.DeliveryApp.printDivide;
import static ru.yandex.practicum.delivery.DeliveryApp.trackableParcels;

public class TreackingService {

    Scanner scanner;

    public TreackingService(Scanner scanner) {
        this.scanner = scanner;
    }

    public void reportStatusAllParcel(){
        System.out.print("Введите новое местоположение посылки - ");
        String newLocation = scanner.nextLine();
        System.out.println();

        for (Trackable trackableParcel : trackableParcels) {
            trackableParcel.reportStatus(newLocation);
            printDivide();
        }
    }
}
