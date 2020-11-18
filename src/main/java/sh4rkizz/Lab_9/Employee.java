package sh4rkizz.Lab_9;

public class Employee {
    private String name, surname, telephoneNumber, residence;
    private double salary;

    public Employee(double salary) {
        this.salary = salary;
        this.name = setRandName();
    }

    public String getName() {
        return name;
    }

    public String setRandName() {
        final String alphaString = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        int k = 25 - (int) (Math.random() * 25);

        for (int i = 0; i < 4; i++) {
            name += alphaString.charAt(k);
            k = 51 - (int) (Math.random() * 25);
        }
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void increaseSalary(double increase) {
        salary += increase;
    }

    public void decreaseSalary(double decrease) {
        salary -= decrease;
    }
}
