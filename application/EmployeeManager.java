package application;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class EmployeeManager {
    private List<Employee> employees;
    private Scanner scanner;

    public EmployeeManager() {
        employees = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addEmployee() {
        System.out.print("Enter employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();
        System.out.print("Enter employee department: ");
        String department = scanner.nextLine();
        System.out.print("Enter employee salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine(); // Consume newline left-over

        Employee employee = new Employee(id, name, department, salary);
        employees.add(employee);
        System.out.println("Employee added successfully.");
    }

    public void removeEmployee() {
        System.out.print("Enter employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        for (Employee employee : employees) {
            if (employee.getId() == id) {
                employees.remove(employee);
                System.out.println("Employee removed successfully.");
                return;
            }
        }

        System.out.println("Employee not found.");
    }

    public void listEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees in the system.");
        } else {
            for (Employee employee : employees) {
                System.out.println(employee.toString());
            }
        }
    }

    public void displayMenu() {
        System.out.println("1. Add Employee");
        System.out.println("2. Remove Employee");
        System.out.println("3. List Employees");
        System.out.println("4. Exit");
    }

    public void run() {
        while (true) {
            displayMenu();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    removeEmployee();
                    break;
                case 3:
                    listEmployees();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        EmployeeManager employeeManager = new EmployeeManager();
        employeeManager.run();
    }
}