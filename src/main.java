import models.Student;
import models.Grade;
import services.StudentService;
import services.GradeService;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        GradeService gradeService = new GradeService();
        Scanner scanner = new Scanner(System.in);

        studentService.loadFromFile();
        gradeService.loadFromFile();

        while (true) {
            System.out.println("\n==== Student Grade Management ====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Add Grade");
            System.out.println("4. View Grades by Student ID");
            System.out.println("5. Calculate Average for Student");
            System.out.println("0. Exit");
            System.out.print("Enter option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Enter ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Course: ");
                    String course = scanner.nextLine();
                    studentService.addStudent(new Student(id, name, course));
                    System.out.println("Student added.");
                    break;

                case 2:
                    for (Student s : studentService.getAllStudents()) {
                        System.out.println(s);
                    }
                    break;

                case 3:
                    System.out.print("Enter Student ID: ");
                    String sid = scanner.nextLine();
                    System.out.print("Enter Grade: ");
                    double score = scanner.nextDouble();
                    scanner.nextLine();
                    gradeService.addGrade(new Grade(sid, score));
                    System.out.println("Grade added.");
                    break;

                case 4:
                    System.out.print("Enter Student ID: ");
                    String gid = scanner.nextLine();
                    for (Grade g : gradeService.getGradesByStudentId(gid)) {
                        System.out.println(g);
                    }
                    break;

                case 5:
                    System.out.print("Enter Student ID: ");
                    String aid = scanner.nextLine();
                    double avg = gradeService.calculateAverage(aid);
                    System.out.println("Average Grade: " + avg);
                    break;

                case 0:
                    System.out.println("Goodbye!");
                    System.exit(0);
            }
        }
    }
}
