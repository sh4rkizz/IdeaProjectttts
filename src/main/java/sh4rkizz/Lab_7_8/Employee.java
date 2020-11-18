package sh4rkizz.Lab_7_8;

public class Employee {
    private String name, surname, position;
    private final double salary;

    public Employee(Operator operator) {
        this.position = operator.getJobTitle();
        this.salary = operator.calcSalary(80000);
    }

    public Employee(Manager manager) {
        this.position = manager.getJobTitle();
        manager.setCompanyIncome();
        this.salary = manager.calcSalary(95000);
    }

    public Employee(TopManager topManager) {
        this.position = topManager.getJobTitle();
        this.salary = topManager.calcSalary(75000);
    }

    public String getJobTitle() {
        return position;
    }

    public double getSalary() {
        return salary;
    }
}
