package ru.yandex.practicum.delivery.service;

import ru.yandex.practicum.delivery.model.FragileParcel;
import ru.yandex.practicum.delivery.model.Parcel;
import ru.yandex.practicum.delivery.model.PerishableParcel;
import ru.yandex.practicum.delivery.model.StandardParcel;
import java.util.Scanner;
import static ru.yandex.practicum.delivery.DeliveryApp.*;

public class ParcelService {

    Scanner scanner;
    String description;
    int weight;
    String deliveryAddress;
    int sendDay;


    public ParcelService(Scanner scanner) {
        this.scanner = scanner;
    }

    public void addParcel() {
        System.out.print("Введите тип посылки(1 - Стандартная, 2 - Хрупкая, 3 - Скоропортящаяся): ");
        int typeOfParcel = Integer.parseInt(scanner.nextLine());
        switch (typeOfParcel) {
            case 1:
                createStandardParcelAndAddToBox();
                printDivide();
                break;
            case 2:
                createFragileParcelAndAddToBoxAndToTrackableList();
                printDivide();
                break;
            case 3:
                createPerishableParcelAndAddToBox();
                printDivide();
                break;
            default:
                System.out.println("Неверный выбор.");
                printDivide();
        }
    }

    public void createStandardParcelAndAddToBox() {
        StandardParcel newStandardParcel;
        getMainInfoFromUserForParcel();

        newStandardParcel = new StandardParcel(description, weight, deliveryAddress, sendDay);
        if (standardParcelBox.addParcel(newStandardParcel)) {
            allParcels.add(newStandardParcel);
        }
    }

    public boolean createFragileParcelAndAddToBoxAndToTrackableList() {
        FragileParcel newFragileParcel;
        getMainInfoFromUserForParcel();

        newFragileParcel = new FragileParcel(description, weight, deliveryAddress, sendDay);

        if (fragileParcelBox.addParcel(newFragileParcel)) {
            allParcels.add(newFragileParcel);
            trackableParcels.add(newFragileParcel);
            return true;
        } else {
            return false;
        }
    }

    public void createPerishableParcelAndAddToBox() {
        PerishableParcel newPerishableParcel;
        getMainInfoFromUserForParcel();


        System.out.print("Введите срок в днях, за который посылка не испортится - ");
        int timeToLive = Integer.parseInt(scanner.nextLine());
        System.out.println();

        newPerishableParcel = new PerishableParcel(description, weight, deliveryAddress, sendDay, timeToLive);
        if (perishableParcelBox.addParcel(newPerishableParcel)) {
            allParcels.add(newPerishableParcel);
        }
    }

    public void sendParcels() {
        // Пройти по allParcels, вызвать packageItem() и deliver()
        for (Parcel parcel : allParcels) {
            parcel.packageItem();
            parcel.deliver();
            printDivide();
        }
    }

    public void calculateCosts() {
        // Посчитать общую стоимость всех доставок и вывести на экран
        int totalCoust = 0;
        for (Parcel parcel : allParcels) {
            totalCoust += parcel.calculateDeliveryCost();
        }
        System.out.println("Общая стоимость всех доставок - " + totalCoust);
        printDivide();
    }

    public void getMainInfoFromUserForParcel() {
        System.out.print("Введите описание товара - ");
        description = scanner.nextLine();
        System.out.println();

        System.out.print("Введите вес товара - ");
        weight = Integer.parseInt(scanner.nextLine());
        System.out.println();

        System.out.print("Введите адрес доставки - ");
        deliveryAddress = scanner.nextLine();
        System.out.println();

        System.out.print("Введите дату отправки - ");
        sendDay = Integer.parseInt(scanner.nextLine());
        System.out.println();
    }
}
