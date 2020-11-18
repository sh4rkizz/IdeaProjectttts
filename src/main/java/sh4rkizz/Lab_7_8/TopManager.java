package sh4rkizz.Lab_7_8;

public class TopManager implements EmployeePosition {
    private final String jobTitle;
    private double salary;

    public TopManager() {
        this.jobTitle = "TopManager";
    }

    @Override
    public String getJobTitle() {
        return jobTitle;
    }

    @Override
    public double calcSalary(double baseSalary) {
        this.salary = baseSalary;

        if (Company.getIncome() > 10000000)
            this.salary += 1.5 * baseSalary;

        return salary;
    }
}
