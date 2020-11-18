package sh4rkizz.Lab_7_8;

public class Operator implements EmployeePosition {
    private final String jobTitle;
    private double salary;

    public Operator() {
        this.jobTitle = "Operator";
    }

    @Override
    public String getJobTitle() {
        return jobTitle;
    }

    @Override
    public double calcSalary(double baseSalary) {
        salary = baseSalary;
        return salary;
    }
}
