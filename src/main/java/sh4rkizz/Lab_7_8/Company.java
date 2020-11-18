package sh4rkizz.Lab_7_8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Company {
    private static double companyIncome = 0;
    private final ArrayList<Employee> staff = new ArrayList<>();
    private final ArrayList<Employee> staffSalarySorted = new ArrayList<>();

    public List<Employee> getTopSalaryStaff(int count) {
        staffSalarySorted.clear();

        for (int j = 0; j < staff.size(); j++)
            for (int i = 0; i < staff.size() - j - 1; i++)
                if (staff.get(i).getSalary() < staff.get(i + 1).getSalary())
                    Collections.swap(staff, i, i + 1);


        for (int i = 0; i < count; i++) {
            staffSalarySorted.add(staff.get(i));
        }

        return staffSalarySorted;
    }
    public List<Employee> getLowestSalaryStaff(int count) {
        staffSalarySorted.clear();

        for (int j = 0; j < staff.size(); j++)
            for (int i = 0; i < staff.size() - j - 1; i++)
                if (staff.get(i).getSalary() > staff.get(i + 1).getSalary())
                    Collections.swap(staff, i, i + 1);

        for (int i = 0; i < count; i++) {
            staffSalarySorted.add(staff.get(i));
        }

        return staffSalarySorted;
    }

    public void hire(Employee intern) {
        staff.add(intern);
    }

    public void hireAll(ArrayList<Employee> interns) {
        staff.addAll(interns);
    }

    public void fire(Employee getRidOfHim) {
        staff.remove(getRidOfHim);
    }

    public static void nullIncome() {
        companyIncome = 0;
    }

    public static void setIncome(double income) {
        companyIncome += income;
    }

    public static double getIncome() {
        return companyIncome;
    }

    public ArrayList<Employee> getStaff() {
        return staff;
    }
}
