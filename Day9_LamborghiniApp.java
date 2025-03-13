import java.util.Scanner;

public class Day9_LamborghiniApp {
    static class Car {
        int id;
        String model;
        int year;
        double price;
        String color;
        Car(int id, String model, int year, double price, String color) {
            this.id = id;
            this.model = model;
            this.year = year;
            this.price = price;
            this.color = color;
        }
        public String toString() {
            return "ID: " + id + ", Model: " + model + ", Year: " + year + 
                   ", Price: " + price + ", Color: " + color;
        }
    }

    static Car cars[] = new Car[100]; 
    static int carCount = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Lamborghini Car Management System ---");
            System.out.println("1. Add Car");
            System.out.println("2. View Cars");
            System.out.println("3. Delete Car");
            System.out.println("4. Search Car by ID");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addCar(sc);
                    break;
                case 2:
                    viewCars();
                    break;
                case 3:
                    deleteCar(sc);
                    break;
                case 4:
                    searchCarById(sc);
                    break;
                case 5:
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

    }
    private static void addCar(Scanner sc) {
        System.out.print("Enter Car ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Model: ");
        String model = sc.nextLine();
        System.out.print("Enter Year: ");
        int year = sc.nextInt();
        System.out.print("Enter Price: ");
        double price = sc.nextDouble();
        sc.nextLine(); 
        System.out.print("Enter Color: ");
        String color = sc.nextLine();
        cars[carCount++] = new Car(id, model, year, price, color);
        System.out.println("Car added successfully!");
    }
    private static void viewCars() {
        if (carCount == 0) {
            System.out.println("No cars available.");
        } else {
            System.out.println("\n--- List of Lamborghini Cars ---");
            for (int i = 0; i < carCount; i++) {
                System.out.println(cars[i]);
            }
        }
    }
    private static void deleteCar(Scanner sc) {
        if (carCount == 0) {
            System.out.println("No cars to delete.");
            return;
        }

        System.out.print("Enter Car ID to delete: ");
        int id = sc.nextInt();

        boolean found = false;
        for (int i = 0; i < carCount; i++) {
            if (cars[i].id == id) {
                for (int j = i; j < carCount - 1; j++) {
                    cars[j] = cars[j + 1];
                }
                cars[--carCount] = null;
                found = true;
                System.out.println("Car deleted successfully.");
                break;
            }
        }
        if (!found) {
            System.out.println("Car with ID " + id + " not found.");
        }
    }
    private static void searchCarById(Scanner sc) {
        if (carCount == 0) {
            System.out.println("No cars available.");
            return;
        }

        System.out.print("Enter Car ID to search: ");
        int id = sc.nextInt();

        boolean found = false;
        for (int i = 0; i < carCount; i++) {
            if (cars[i].id == id) {
                System.out.println("Car Found: " + cars[i]);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Car with ID " + id + " not found.");
        }
    }
}
