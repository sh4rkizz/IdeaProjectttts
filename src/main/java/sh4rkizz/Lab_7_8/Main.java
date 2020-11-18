package sh4rkizz.Lab_7_8;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Main {
    private static boolean checkError(int cnt, Company samsung) {
        if (cnt <= 0) {
            System.out.println("Incorrect input\n" +
                    "'count' = " + cnt + " is not a natural number");
            return false;
        } else if (cnt > samsung.getStaff().size()) {
            System.out.println("Incorrect input\n"
                    + "Currently, 'Company' has less than " + cnt + "employees");
            return false;
        } else return true;
    }

    public static void main(String[] args) {
        NumberFormat nf = new DecimalFormat("#.##");
        Company apple = new Company();
        int staffSize, count, k, cnt = 0;

        for (int i = 0; i < 180; i++) {
            Employee operator = new Employee(new Operator());
            apple.hire(operator);
        }

        for (int i = 0; i < 80; i++) {
            Employee manager = new Employee(new Manager());
            apple.hire(manager);
        }

        for (int i = 0; i < 10; i++) {
            Employee topManager = new Employee(new TopManager());
            apple.hire(topManager);
        }

        staffSize = apple.getStaff().size();

        count = (int) (15 - Math.random() * 5);
        System.out.println("Top salary list:");
        if (checkError(count, apple))
            for (int i = 0; i < count; i++)
                System.out.println(nf.format(apple.getTopSalaryStaff(count).get(i).getSalary()) + " rub.");

        count = 30;
        System.out.println("Lowest salary list:");
        if (checkError(count, apple))
            for (int i = 0; i < count; i++)
                System.out.println(nf.format(apple.getLowestSalaryStaff(count).get(i).getSalary()) + " rub.");

        for (int i = 0; i < staffSize / 2; i++) {
            k = (int) (Math.random() * apple.getStaff().size());
            apple.fire(apple.getStaff().get(k));
        }

        Company.nullIncome();
        for (Employee employee : apple.getStaff())
            if (employee.getJobTitle().equals("Manager"))
                Company.setIncome((employee.getSalary() - 95000) * 20);

        for (int i = apple.getStaff().size() - 1; i >= 0; i--)
            if (apple.getStaff().get(i).getJobTitle().equals("TopManager")) {
                cnt++;
                apple.fire(apple.getStaff().get(i));
            }
        for (int i = 0; i < cnt; i++) {
            Employee topManager = new Employee(new TopManager());
            apple.hire(topManager);
        }

        staffSize = apple.getStaff().size();
        for (int i = 0; i < staffSize; i++)
            System.out.println(i + " " + apple.getStaff().get(i).getJobTitle()
                    + " " + nf.format(apple.getStaff().get(i).getSalary()) + " rub.");

        count = (int) (15 - Math.random() * 5);
        System.out.println("Top salary list after dismissal of 50% of employees:");
        if (checkError(count, apple))
            for (int i = 0; i < count; i++)
                System.out.println(nf.format(apple.getTopSalaryStaff(count).get(i).getSalary()) + " rub.");

        count = 30;
        System.out.println("Lowest salary list after dismissal of 50% of employees:");
        if (checkError(count, apple))
            for (int i = 0; i < count; i++)
                System.out.println(nf.format(apple.getLowestSalaryStaff(count).get(i).getSalary()) + " rub.");
    }
}
