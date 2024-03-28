package tuan2_quanlyxe;

import java.util.Scanner;

public class VehicleTest {
    public static void main(String[] args) throws Exception {
        Vehicle v[] = null;
        int opt, n;
        Scanner scn = new Scanner(System.in);
        System.out.println("Amount of people: ");
        n = scn.nextInt();
        try {
            do {
                opt = menu();
                switch (opt) {
                    case 1: {
                        v = new Vehicle[n];
                        for (int i = 0; i < n; i++) {
                            System.out.println("The " + (i + 1) + " person");
                            v[i] = new Vehicle();
                            inputVehicle(v[i]);
                        }
                        break;
                    }
                    case 2: {
                        System.out.println("Vehicle Management Program!");
                        printTitle();
                        for (int i = 0; i < n; i++) {
                            System.out.println(v[i].toString());
                        }
                        break;
                    }
                    case 3: {
                        System.out.println("Goodbye!");
                        break;
                    }
                }
            } while (opt != 3);
        } catch (Exception err) {
            System.out.println(err.getMessage());
        } finally {
            // Do not close the scanner for System.in to avoid issues
            // scn.close();
        }
    }

    static void inputVehicle(Vehicle xe) throws Exception {
        Scanner scn = new Scanner(System.in);
        scn.nextLine();
        System.out.println("\tInput owner name: ");
        xe.setOwnerName(scn.nextLine());
        System.out.println("\tInput vehicle name: ");
        xe.setVehicleName(scn.nextLine());
        System.out.println("\tInput capacity: ");
        xe.setCapacity(scn.nextInt());
        System.out.println("\tInput price: ");
        xe.setPrice(scn.nextFloat());
        // Do not close the scanner for System.in to avoid issues
        // scn.close();
    }

    public static int menu() {
        int chos;
        Scanner scn = new Scanner(System.in);
        System.out.println("***Menu***\n" + "1.Input and creat\n" + "2.Print \n" + "3.Exit\n");
        chos = setNumber("Your choose: ");
        // Do not close the scanner for System.in to avoid issues
        // scn.close();
        return chos;
    }

    public static int setNumber(String str) {
        int n = 0;
        Scanner scn = new Scanner(System.in);
        System.out.println(str);
        n = scn.nextInt();
        // Do not close the scanner for System.in to avoid issues
        // scn.close();
        return n;
    }

    static void printTitle() {
        String s = String.format("%20s %15s %12s %20s %15s", "Owner Name", "Vehicle Name", "Capacity", "Price", "Tax");
        System.out.println(s);
    }
}
