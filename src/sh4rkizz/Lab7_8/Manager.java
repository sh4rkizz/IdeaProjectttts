package sh4rkizz.Lab7_8;

public class Manager implements EmployeePosition {
    private final String jobTitle;
    private double salary, localIncome;

    public Manager() {
        this.jobTitle = "Manager";
    }

    public void setCompanyIncome() {
        this.localIncome = 140000 - Math.random() * 25000;
        Company.setIncome(localIncome);
    }

    @Override
    public String getJobTitle() {
        return jobTitle;
    }

    @Override
    public double calcSalary(double baseSalary) {
        this.salary = baseSalary + this.localIncome * 0.05;
        return salary;
    }
}
