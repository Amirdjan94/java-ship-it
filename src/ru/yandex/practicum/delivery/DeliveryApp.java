package ru.yandex.practicum.delivery;

import ru.yandex.practicum.delivery.model.*;
import ru.yandex.practicum.delivery.service.ParcelBoxesService;
import ru.yandex.practicum.delivery.service.ParcelService;
import ru.yandex.practicum.delivery.service.TreackingService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    public static final Scanner scanner = new Scanner(System.in);
    public static List<Parcel> allParcels = new ArrayList<>();
    public static List<Trackable> trackableParcels = new ArrayList<>();
    public static ParcelBox<StandardParcel> standardParcelBox;
    public static ParcelBox<PerishableParcel> perishableParcelBox;
    public static ParcelBox<FragileParcel> fragileParcelBox;



    public static void main(String[] args) {

        new ParcelBoxesService(scanner).createBoxForParcel();
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    new ParcelService(scanner).addParcel();
                    break;
                case 2:
                    new ParcelService(scanner).sendParcels();
                    break;
                case 3:
                    new ParcelService(scanner).calculateCosts();
                    break;
                case 4:
                    new TreackingService(scanner).reportStatusAllParcel();
                    break;
                case 5:
                    new ParcelBoxesService(scanner).getParcels();
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
        System.out.println("5 — Показать содержимое коробки");
        System.out.println("0 — Завершить");
    }

    public static void printDivide() {
        System.out.println("-".repeat(20));
    }





}

