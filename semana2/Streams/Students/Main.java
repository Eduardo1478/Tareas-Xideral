package semana2.Streams.Students;

import java.util.stream.Collectors;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Student> students = Arrays.asList(
            new Student("Alice", "S001", Arrays.asList(85.0, 90.0, 80.0), 95.0),
            new Student("Bob", "S002", Arrays.asList(70.0, 75.0, 80.0), 85.0),
            new Student("Charlie", "S003", Arrays.asList(90.0, 92.0, 88.0), 90.0),
            new Student("Dave", "S004", Arrays.asList(55.0, 60.0, 65.0), 50.0),
            new Student("Eve", "S005", Arrays.asList(82.0, 85.0, 87.0), 88.0),
            new Student("Frank", "S006", Arrays.asList(60.0, 62.0, 65.0), 70.0),
            new Student("Grace", "S007", Arrays.asList(95.0, 93.0, 97.0), 99.0),
            new Student("Hannah", "S008", Arrays.asList(78.0, 80.0, 79.0), 82.0),
            new Student("Ivy", "S009", Arrays.asList(88.0, 85.0, 90.0), 92.0),
            new Student("Jack", "S010", Arrays.asList(67.0, 70.0, 68.0), 75.0),
            new Student("Karen", "S011", Arrays.asList(82.0, 79.0, 85.0), 84.0),
            new Student("Leo", "S012", Arrays.asList(60.0, 65.0, 70.0), 68.0),
            new Student("Mia", "S013", Arrays.asList(75.0, 78.0, 80.0), 83.0),
            new Student("Nina", "S014", Arrays.asList(92.0, 95.0, 91.0), 94.0),
            new Student("Oscar", "S015", Arrays.asList(85.0, 82.0, 88.0), 87.0),
            new Student("Paul", "S016", Arrays.asList(50.0, 55.0, 60.0), 58.0),
            new Student("Quinn", "S017", Arrays.asList(78.0, 75.0, 80.0), 77.0),
            new Student("Rita", "S018", Arrays.asList(68.0, 70.0, 65.0), 72.0),
            new Student("Sam", "S019", Arrays.asList(95.0, 97.0, 98.0), 100.0),
            new Student("Tina", "S020", Arrays.asList(87.0, 85.0, 88.0), 90.0),
            new Student("Uma", "S021", Arrays.asList(60.0, 63.0, 65.0), 67.0),
            new Student("Victor", "S022", Arrays.asList(77.0, 80.0, 78.0), 82.0),
            new Student("Wendy", "S023", Arrays.asList(90.0, 88.0, 92.0), 91.0),
            new Student("Xander", "S024", Arrays.asList(65.0, 67.0, 68.0), 70.0),
            new Student("Yara", "S025", Arrays.asList(80.0, 82.0, 79.0), 84.0),
            new Student("Zack", "S026", Arrays.asList(72.0, 75.0, 70.0), 78.0)
        );

        //Gets the overall grade average of the whole class
        double classAverage = students.stream()
            .mapToDouble(Student::getOverallGrade)
            .average()
            .orElse(0.0);

        //Selects only the students with a failing grade
        List<Student> failingStudents = students.stream()
            .filter(student -> student.getGradeLevel().equals("F"))
            .collect(Collectors.toList());

        //Selects the students with the highest grade
        List<Student> topStudents = students.stream()
            .filter(student -> student.getGradeLevel().equals("A"))
            .collect(Collectors.toList());
        
        //Sort all the students from highest to lowest
        List<Student> sortedStudents = students.stream()
            .sorted(Comparator.comparingDouble(Student::getOverallGrade).reversed())
            .collect(Collectors.toList());

        //Divide students between levels
        Map<String, List<Student>> studentsByGradeLevel = students.stream()
            .collect(Collectors.groupingBy(Student::getGradeLevel));



        System.out.println("Class Average: " + classAverage);

        System.out.println("Failing Students: ");
        failingStudents.forEach(report -> System.out.println(report));

        System.out.println("Top Students: ");
        topStudents.forEach(report -> System.out.println(report));

        System.out.println("Students Sorted by Grade: ");
        sortedStudents.forEach(report -> System.out.println(report));


        studentsByGradeLevel.forEach((gradeLevel, studentList) -> {
            System.out.println("Grade Level: " + gradeLevel);
            for (Student student : studentList) {
                System.out.println(student);
            }
            System.out.println(); 
        });


    }
}
