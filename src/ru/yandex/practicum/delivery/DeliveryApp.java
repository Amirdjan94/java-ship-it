package ru.yandex.practicum.delivery;

import ru.yandex.practicum.delivery.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static List<Parcel> allParcels = new ArrayList<>();
    private static List<Trackable> trackableParcels = new ArrayList<>();
    private static ParcelBox<StandardParcel> standardParcelBox;
    private static ParcelBox<PerishableParcel> perishableParcelBox;
    private static ParcelBox<FragileParcel> fragileParcelBox;



    public static void main(String[] args) {
        createBoxForParcel();
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 4:
                    reportStatusAllParcel();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 — Трекинг отправления всех посылок");
        System.out.println("0 — Завершить");
    }

    // реализуйте методы ниже

    private static void addParcel() {
        // Подсказка: спросите тип посылки и необходимые поля, создайте объект и добавьте в allParcels
        System.out.print("Введите тип посылки(1 - Стандартная, 2 - Хрупкая, 3 - Скоропортящаяся): ");
        int typeOfParcel = Integer.parseInt(scanner.nextLine());
        switch (typeOfParcel) {
            case 1:
                allParcels.add(createStandardParcel());
                printDivide();
                break;
            case 2:
                FragileParcel fragileParcel = createFragileParcel();
                allParcels.add(fragileParcel);
                trackableParcels.add(fragileParcel);
                printDivide();
                break;
            case 3:
                allParcels.add(createPerishableParcel());
                printDivide();
                break;
            default:
                System.out.println("Неверный выбор.");
                printDivide();
        }
    }

    private static StandardParcel createStandardParcel(){
        StandardParcel newStandardParcel;

        System.out.print("Введите описание товара - ");
        String description = scanner.nextLine();
        System.out.println();

        System.out.print("Введите вес товара - ");
        int weight = Integer.parseInt(scanner.nextLine());
        System.out.println();

        System.out.print("Введите адрес доставки - ");
        String deliveryAddress = scanner.nextLine();
        System.out.println();

        System.out.print("Введите дату отправки- ");
        int sendDay = Integer.parseInt(scanner.nextLine());
        System.out.println();

        newStandardParcel = new StandardParcel(description, weight, deliveryAddress, sendDay);
        standardParcelBox.addParcel(newStandardParcel);
        return newStandardParcel;
    }

    private static FragileParcel createFragileParcel(){
        FragileParcel newFragileParcel;

        System.out.print("Введите описание товара - ");
        String description = scanner.nextLine();
        System.out.println();

        System.out.print("Введите вес товара - ");
        int weight = Integer.parseInt(scanner.nextLine());
        System.out.println();

        System.out.print("Введите адрес доставки - ");
        String deliveryAddress = scanner.nextLine();
        System.out.println();

        System.out.print("Введите дату отправки- ");
        int sendDay = Integer.parseInt(scanner.nextLine());
        System.out.println();

        newFragileParcel = new FragileParcel(description, weight, deliveryAddress, sendDay);
        fragileParcelBox.addParcel(newFragileParcel);
        return newFragileParcel;
    }

    private static PerishableParcel createPerishableParcel(){
        PerishableParcel newPerishableParcel;

        System.out.print("Введите описание товара - ");
        String description = scanner.nextLine();
        System.out.println();

        System.out.print("Введите вес товара - ");
        int weight = Integer.parseInt(scanner.nextLine());
        System.out.println();

        System.out.print("Введите адрес доставки - ");
        String deliveryAddress = scanner.nextLine();
        System.out.println();

        System.out.print("Введите дату отправки - ");
        int sendDay = Integer.parseInt(scanner.nextLine());
        System.out.println();

        System.out.print("Введите срок в днях, за который посылка не испортится - ");
        int timeToLive = Integer.parseInt(scanner.nextLine());
        System.out.println();

        newPerishableParcel = new PerishableParcel(description, weight, deliveryAddress, sendDay, timeToLive);
        perishableParcelBox.addParcel(newPerishableParcel);
        return newPerishableParcel;
    }

    private static void sendParcels() {
        // Пройти по allParcels, вызвать packageItem() и deliver()
        for (Parcel parcel : allParcels) {
            parcel.packageItem();
            parcel.deliver();
            printDivide();
        }
    }

    private static void calculateCosts()  {
        // Посчитать общую стоимость всех доставок и вывести на экран
        int totalCoust = 0;
        for (Parcel parcel : allParcels) {
            totalCoust += parcel.calculateDeliveryCost();
        }
        System.out.println("Общая стоимость всех доставок - " + totalCoust);
        printDivide();
    }

    public static void printDivide() {
        System.out.println("-".repeat(20));
    }

    public static void reportStatusAllParcel(){
        System.out.print("Введите новое местоположение посылки - ");
        String newLocation = scanner.nextLine();
        System.out.println();

        for (Trackable trackableParcel : trackableParcels) {
            trackableParcel.reportStatus(newLocation);
            printDivide();
        }
    }

    public static void createBoxForParcel(){
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

}

