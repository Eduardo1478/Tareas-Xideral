package semana2.Streams.Students;

import java.util.List;

public class Student {
    private String name;
    private String id;
    private List<Double> homeWorkGrades;
    private Double examGrade;

    // Constructor, getters, and setters
    public Student(String name, String id, List<Double> homeWorkGrades, Double examGrade) {
        this.name = name;
        this.id = id;
        this.homeWorkGrades = homeWorkGrades;
        this.examGrade = examGrade;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public List<Double> getHomeWorkGrades() {
        return homeWorkGrades;
    }

    public Double getExamGrade() {
        return examGrade;
    }

    // Method to calculate the average homework grade
    public double getAverageHomeWorkGrade() {
        return homeWorkGrades.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }

    // Method to calculate the overall grade (weighted average)
    public double getOverallGrade() {
        double homeWorkAverage = getAverageHomeWorkGrade();
        // Assuming homework contributes 40% and exam contributes 60% to the overall grade
        return (homeWorkAverage * 0.4) + (examGrade * 0.6);
    }

    // Method to get grade level (A, B, C, etc.)
    public String getGradeLevel() {
        double overallGrade = getOverallGrade();
        if (overallGrade >= 90) return "A";
        else if (overallGrade >= 80) return "B";
        else if (overallGrade >= 70) return "C";
        else if (overallGrade >= 60) return "D";
        else return "F";
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Grade: " + getOverallGrade() + ", Level: " + getGradeLevel();
    }
}