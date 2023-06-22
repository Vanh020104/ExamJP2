package demo1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CustomerManage {
    private Map<String, Customer> customerMap;
    private Scanner scanner;

    public CustomerManage() {
        customerMap = new HashMap<>();
        scanner = new Scanner(System.in);
    }

    public void menu() {
        int choose;
        do {
            System.out.println("------Menu------");
            System.out.println("1. Add new customer");
            System.out.println("2. Find by name");
            System.out.println("3. Display all");
            System.out.println("4. Exit");
            System.out.print("Please choose a function: ");
            choose = scanner.nextInt();
            scanner.nextLine();

            switch (choose) {
                case 1:
                    addCus();
                    break;
                case 2:
                    search();
                    break;
                case 3:
                    display();
                    break;
                case 4:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            System.out.println();
        } while (choose != 4);

        scanner.close();
    }

    private void addCus() {
        System.out.println("------ Add New Customer ------");
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter phone: ");
        String phone = scanner.nextLine();

        Customer customer = new Customer(name, email, phone);
        customerMap.put(name, customer);
        System.out.println("Customer added successfully!");
    }

    private void search() {
        System.out.println("------ Find Customer by Name ------");
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        Customer customer = customerMap.get(name);
        if (customer != null) {
            System.out.println("Name: " + customer.getName());
            System.out.println("Email: " + customer.getEmail());
            System.out.println("Phone: " + customer.getPhone());
        } else {
            System.out.println("Not found.");
        }
    }

    private void display() {
        System.out.println("------ All Customers ------");
        if (customerMap.isEmpty()) {
            System.out.println("No customers found.");
        } else {
            for (Customer customer : customerMap.values()) {
                System.out.println("Name: " + customer.getName());
                System.out.println("Email: " + customer.getEmail());
                System.out.println("Phone: " + customer.getPhone());
                System.out.println("--------------------");
            }
        }
    }
}