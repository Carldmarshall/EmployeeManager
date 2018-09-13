
package employeemanager;

import javafx.application.Application;

import java.util.Scanner;

public class EmployeeManager {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Test");
        boolean running = true;

        while(running){
            System.out.println("What do you want do to?\n" +
                    "1. Enter Employee management.\n" +
                    "2. Enter Employee statistics.\n" +
                    "0. Exit.");
            System.out.print("Choice: ");
            int choice = sc.nextInt();

            switch (choice){
                case 1:
                    employeeManagement();
                    break;
                case 2:
                    employeeStatitics();
                    break;
                case 0:
                    System.out.println("Exiting application.");
                    System.exit(0);
                default:
                    System.out.println("Wrong input!");
                    break;
            }

        }
    }
    static void employeeManagement(){
        System.out.println("What do you want do to?\n" +
                "1. Register employee.\n" +
                "2. Delete employee.\n" +
                "3. Update name of employee.\n" +
                "4. Update the birthdate of employee.\n" +
                "5. Update the department of employee.\n" +
                "6. Update Salary of employee.\n" +
                "7. Search employee by name.\n" +
                "8. Search employee number.\n" +
                "9. Search employee by department.\n" +
                "10. Display all employees.\n" +
                "0. Back to main menu.\n");
        System.out.print("Choice: ");
        int choice = sc.nextInt();
    }
    static void employeeStatitics(){
        System.out.println("What do you want do to?\n" +
                "1. Average wage at the company.\n" +
                "2. Maximum salary in the company.\n" +
                "3. Minimum salary in the company.\n" +
                "4. Total bonus.\n" +
                "5. Women in percentage in the company.\n" +
                "6. Men percentage of the various work role categories.\n" +
                "0. Back to main menu.\n");
        System.out.print("Choice: ");
        int choice = sc.nextInt();
    }
    
}
