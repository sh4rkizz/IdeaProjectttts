package sh4rkizz.Lab9;

import java.util.ArrayList;

public class Main {
    private static final Company apple = new Company();
    private static final ArrayList<Employee> interns = new ArrayList<>();

    public static void test() {
        Factory factory;
        factory = (interns) -> apple.handleEmployees(interns);
        factory.handleEmployees(interns);
        apple.outStaffSalary();
        interns.clear();
    }

    public static void main(String[] args) {

        //Создание стартовой компании
        for (int i = 0; i < 30; i++)
            interns.add(new Employee(30000));
        apple.hireAll(interns);
        interns.clear();

        //Тест найма
        for (int i = 0; i < 10; i++)
            interns.add(new Employee(15000));
        apple.handleEmployees(interns);
        apple.outStaffSalary();
        interns.clear();

        //Тест увольнения
        for (int i = 0; i < apple.getStaff().size(); i += 2)
            interns.add(apple.getStaff().get(i));
        test();

        //Тест прибавки к ЗП
        for (Employee employee : apple.getStaff())
            if (employee.getSalary() < 35000)
                interns.add(employee);
        test();

        //Тест урезания ЗП
        for (Employee employee : apple.getStaff())
            if (employee.getSalary() > 45000)
                interns.add(employee);
        test();
    }
}
