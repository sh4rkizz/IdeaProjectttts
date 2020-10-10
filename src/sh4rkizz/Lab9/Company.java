package sh4rkizz.Lab9;

import java.util.ArrayList;
import java.util.Scanner;

public class Company implements Factory {
    private final ArrayList<Employee> staff = new ArrayList<>();
    private final Scanner in = new Scanner(System.in);

    public void hire(Employee intern) {
        staff.add(intern);
    }

    public void hireAll(ArrayList<Employee> interns) {
        for (Employee intern : interns)
            hire(intern);
    }

    public void fire(Employee getRidOfHim) {
        staff.remove(getRidOfHim);
    }

    public void fireAll(ArrayList<Employee> getRidOfThem) {
        for (Employee getRidOfHim : getRidOfThem)
            fire(getRidOfHim);
    }

    public ArrayList<Employee> getStaff() {
        return staff;
    }

    public void increaseSalary(ArrayList<Employee> employees, double increment) {
        for (Employee employee : employees)
            employee.increaseSalary(increment);
    }

    public void decreaseSalary(ArrayList<Employee> employees, double decrement) {
        for (Employee employee : employees)
            employee.decreaseSalary(decrement);
    }

    public void outStaffSalary() {
        for (Employee emp : staff)
            System.out.println(emp.getName() + " " + emp.getSalary() + "rub.");
    }

    @Override
    public void handleEmployees(ArrayList<Employee> employees) {
        System.out.println("1 - if you want to hire these interns to the company");
        System.out.println("2 - if you want to fire these employees");
        System.out.println("3 - if you want to increase the salary of these workers");
        System.out.println("4 - if you want to decrease the salary of these workers");
        System.out.println("5 - if you want to get the list of employees");

        switch (in.nextShort()) {
            case 1 -> hireAll(employees);
            case 2 -> fireAll(employees);
            case 3 -> {
                System.out.println("Input the salary`s increment");
                increaseSalary(employees, in.nextDouble());
            }
            case 4 -> {
                System.out.println("Input the salary`s decrement");
                decreaseSalary(employees, in.nextDouble());
            }
            case 5 -> {
                System.out.println("Employees list:");
                outStaffSalary();
            }
            default -> System.exit(0);
        }
    }
}
