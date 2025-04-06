package services;

import models.Student;
import java.io.*;
import java.util.*;

public class StudentService {
    private List<Student> students = new ArrayList<>();
    private final String FILE_NAME = "data/students.txt";

    public void addStudent(Student student) {
        students.add(student);
        saveToFile();
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public void loadFromFile() {
        students.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                students.add(new Student(data[0], data[1], data[2]));
            }
        } catch (IOException e) {
            System.out.println("No existing student data found.");
        }
    }

    public void saveToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Student s : students) {
                bw.write(s.getId() + "," + s.getName() + "," + s.getCourse());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
