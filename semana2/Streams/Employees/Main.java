package semana2.Streams.Employees;

import java.util.stream.Collectors;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        //Employees data set
        List<Employee> employees = Arrays.asList(
            new Employee("Tom", "IT", 75000, 32, Arrays.asList("Project A", "Project B")),
            new Employee("Jerry", "HR", 50000, 44, Arrays.asList("Project C")),
            new Employee("Max", "IT", 85000, 81, Arrays.asList("Project D", "Project E")),
            new Employee("Jake", "Finance", 65000, 16, Arrays.asList("Project F")),
            new Employee("Paul", "IT", 90000, 56, Arrays.asList("Project G", "Project H")),
            new Employee("Kathy", "Sales", 66000, 42, Arrays.asList("Project Q")),
            new Employee("Leo", "Marketing", 54000, 32, Arrays.asList("Project R")),
            new Employee("Mallory", "IT", 87000, 18, Arrays.asList("Project S", "Project T")),
            new Employee("Niaj", "Finance", 68000, 17, Arrays.asList("Project U", "Project V")),
            new Employee("Oscar", "Sales", 72000, 53, Arrays.asList("Project W")),
            new Employee("Peggy", "Marketing", 56000, 42, Arrays.asList("Project X")),
            new Employee("Quentin", "HR", 51000, 68, Arrays.asList("Project Y")),
            new Employee("Rita", "Finance", 69000, 86, Arrays.asList("Project Z")),
            new Employee("Sybil", "IT", 81000, 39, Arrays.asList("Project AA", "Project AB")),
            new Employee("Trent", "Marketing", 52000, 31, Arrays.asList("Project AC")),
            new Employee("Uma", "Sales", 74000, 72, Arrays.asList("Project AD", "Project AE")),
            new Employee("Victor", "IT", 92000, 16, Arrays.asList("Project AF", "Project AG")),
            new Employee("Wendy", "HR", 49000, 22, Arrays.asList("Project AH")),
            new Employee("Xander", "Finance", 70000, 53, Arrays.asList("Project AI", "Project AJ")),
            new Employee("Yolanda", "Sales", 73000, 62, Arrays.asList("Project AK")),
            new Employee("Zara", "Marketing", 58000, 41, Arrays.asList("Project AL"))

        );

        //Filtering the employees that are older than 21
        List<Employee> matureEmployees = employees.stream()
            .filter(e -> e.getAge() > 21)
            .collect(Collectors.toList());

        //Creating a report for those employees over the age of 21
        List<String> employeeReports = matureEmployees.stream()
            .map(emp -> "Name: " + emp.getName() + ", Dept: " + emp.getDepartment() + ", Salary: $" + emp.getSalary())
            .collect(Collectors.toList());

        //Getting all the projects that involve employees over the age of 21
        List<String> allProjects = matureEmployees.stream()
            .flatMap(emp -> emp.getProjects().stream())
            .collect(Collectors.toList());

        //Sorting employees by department
        Map<String, List<Employee>> employeesByDepartment = matureEmployees.stream()
            .collect(Collectors.groupingBy(Employee::getDepartment));

        //Finding the average salary of the employees in each department
        Map<String, Double> averageSalaryByDepartment = employeesByDepartment.entrySet().stream()
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                entry -> entry.getValue().stream()
                    .mapToDouble(Employee::getSalary)
                    .average()
                    .orElse(0.0)
        ));

        System.out.println("Adult Employees Reports: ");
        employeeReports.forEach(report -> System.out.println(report));
        System.out.println("All Projects: " + allProjects);
        System.out.println("Average Salary by Department: " + averageSalaryByDepartment);
    }

}
