package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int amountOfWater = 400;
        int amountOfMilk = 540;
        int amountOfBeans = 120;
        int disposableCups = 9;
        int amountOfMoney = 550;

        int[] info = new int[5];
        info[0] = amountOfWater;
        info[1] = amountOfMilk;
        info[2] = amountOfBeans;
        info[3] = disposableCups;
        info[4] = amountOfMoney;

        String action = "";
        while (!action.equals("exit")) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            action = scanner.next();
            System.out.println();
            choseAction(scanner, action, info);
        }
    }

    public static void buy(Scanner scanner, int[] info) {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String option = scanner.next();

        switch (option) {
            case "1":
                if (info[0] - 250 >= 0 && info[2] - 16 >= 0 && info[3] - 1 >= 0) {
                    info[0] -= 250;
                    info[2] -= 16;
                    info[3] -= 1;
                    info[4] += 4;
                    System.out.println("I have enough resources, making you a coffee!\n");
                } else {
                    System.out.println("Sorry, not enough water!");
                }
                break;
            case "2":
                if (info[0] - 350 >= 0 && info[1] - 75 >= 0 && info[2] - 20 >= 0 && info[3] - 1 >= 0) {
                    info[0] -= 350;
                    info[1] -= 75;
                    info[2] -= 20;
                    info[3] -= 1;
                    info[4] += 7;
                    System.out.println("I have enough resources, making you a coffee!\n");
                } else {
                    System.out.println("Sorry, not enough water!");
                }
                break;
            case "3":
                if (info[0] - 200 >= 0 && info[1] - 100 >= 0 && info[2] - 12 >= 0 && info[3] - 1 >= 0) {
                    info[0] -= 200;
                    info[1] -= 100;
                    info[2] -= 12;
                    info[3] -= 1;
                    info[4] += 6;
                    System.out.println("I have enough resources, making you a coffee!\n");
                } else {
                    System.out.println("Sorry, not enough water!");
                }
                break;
        }
    }

    public static void fill(Scanner scanner, int[] info) {
        System.out.println("Write how many ml of water you want to add:");
        info[0] += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        info[1] += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        info[2] += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add:");
        info[3] += scanner.nextInt();
    }

    public static void take(int[] info) {
        System.out.printf("I gave you $%d %n", info[4]);
        info[4] = 0;
    }

    public static void choseAction(Scanner scanner, String action, int[] info) {
        if (action.equals("buy")) {
            buy(scanner, info);
        } else if (action.equals("fill")) {
            fill(scanner, info);
        } else if (action.equals("take")) {
            take(info);
        } else if (action.equals("remaining")) {
            printInfo(info);
        }
    }

    public static void printInfo(int[] info) {
        System.out.printf("The coffee machine has: %n%d ml of water %n%d ml of milk " +
                        "%n%d g of coffee beans %n%d disposable cups %n$%d of money %n%n",
                info[0], info[1], info[2], info[3], info[4]);
    }
}
