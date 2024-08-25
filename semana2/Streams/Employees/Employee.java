package semana2.Streams.Employees;

import java.util.List;


public class Employee {

    private String name;
    private String department;
    private double salary;
    private int age;
    private List<String> projects;

    public Employee(String name, String department, double salary, int age, List<String> projects) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.age = age;
        this.projects = projects;
    }


    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public List<String> getProjects() {
        return projects;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Dept: " + department + ", Salary: $" + salary + 
               ", Experience: " + age + " years";
    }

}
