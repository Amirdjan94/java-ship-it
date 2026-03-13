package ru.yandex.practicum.delivery.service;

import ru.yandex.practicum.delivery.model.ParcelBox;
import java.util.Scanner;
import static ru.yandex.practicum.delivery.DeliveryApp.*;
import static ru.yandex.practicum.delivery.DeliveryApp.printDivide;

public class ParcelBoxesService {
    Scanner scanner;

    public ParcelBoxesService(Scanner scanner) {
        this.scanner = scanner;
    }

    public void createBoxForParcel(){
        int weightParcel;

        System.out.print("Введите максимальный вес для коробки со стандартными посылками - ");
        weightParcel = Integer.parseInt(scanner.nextLine());
        standardParcelBox = new ParcelBox<>(weightParcel);
        System.out.println();

        System.out.print("Введите максимальный вес для коробки с хрупкими посылками - ");
        weightParcel = Integer.parseInt(scanner.nextLine());
        perishableParcelBox = new ParcelBox<>(weightParcel);
        System.out.println();

        System.out.print("Введите максимальный вес для коробки со скоропортящимися посылками - ");
        weightParcel = Integer.parseInt(scanner.nextLine());
        fragileParcelBox = new ParcelBox<>(weightParcel);
        System.out.println();
    }

    public void getParcels(){
        System.out.println("Введите тип коробки содержимое которого хотите увидеть(1 - Стандартная, 2 - Хрупкая, 3 - Скоропортящаяся): ");
        int typeOfParcel = Integer.parseInt(scanner.nextLine());

        switch (typeOfParcel) {
            case 1:
                standardParcelBox.getAllParcels();
                printDivide();
                break;
            case 2:
                fragileParcelBox.getAllParcels();
                printDivide();
                break;
            case 3:
                perishableParcelBox.getAllParcels();
                printDivide();
                break;
            default:
                System.out.println("Неверный выбор.");
                printDivide();
        }

    }
}
