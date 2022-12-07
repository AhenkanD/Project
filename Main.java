package Project;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

final class Student {
    private String name;
    private String id;
    private String unit;
    private String grade;
    private String status;
    private String fee;

    public Student(String name, String id, String unit, String grade, String status, String fee) {
        this.name = name;
        this.id = id;
        this.unit = unit;
        this.grade = grade;
        this.status = status;
        this.fee = fee;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getUnit() {
        return unit;
    }

    public String getGrade() {
        return grade;
    }

    public String getStatus() {
        return status;
    }

    public String getFee() {
        return fee;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", unit='" + unit + '\'' +
                ", grade='" + grade + '\'' +
                ", status='" + status + '\'' +
                ", fee='" + fee + '\'' +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();
        int option = 0;
        while (option != 6) {
            System.out.println("1. Add a student");
            System.out.println("2. Display all students");
            System.out.println("3. Search for a student");
            System.out.println("4. Sort students");
            System.out.println("5. Display all students with HD");
            System.out.println("6. Exit");
            System.out.print("Enter your option: ");
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student id: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter student unit: ");
                    String unit = scanner.nextLine();
                    System.out.print("Enter student grade: ");
                    String grade = scanner.nextLine();
                    System.out.print("Enter student status: ");
                    String status = scanner.nextLine();
                    System.out.print("Enter student fee: ");
                    String fee = scanner.nextLine();
                    students.add(new Student(name, id, unit, grade, status, fee));
                    break;
                case 2:
                    for (Student student : students) {
                        System.out.println(student);
                    }
                    break;
                case 3:
                    System.out.print("Enter student name or id: ");
                    String search = scanner.nextLine();
                    boolean found = false;
                    for (Student student : students) {
                        if (student.getName().equalsIgnoreCase(search) || student.getId().equalsIgnoreCase(search)) {
                            System.out.println(student);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Student not found");
                    }
                    break;
                case 4:
                    Collections.sort(students, new Comparator<Student>() {
                        @Override
                        public int compare(Student o1, Student o2) {
                            return o1.getName().compareToIgnoreCase(o2.getName());
                        }
                    });
                    for (Student student : students) {
                        System.out.println(student);
                    }
                    break;
                case 5:
                    for (Student student : students) {
                        if (student.getGrade().equalsIgnoreCase("HD")) {
                            System.out.println(student);
                        }
                    }
                    break;
                case 6:
                    System.out.println("Goodbye");
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }
}

