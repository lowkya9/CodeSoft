import java.util.*;

class Student {
    String name;
    int rollNo;
    String grade;

    Student(String name, int rollNo, String grade) {
        this.name = name;
        this.rollNo = rollNo;
        this.grade = grade;
    }

    public String toString() {
        return name + " | Roll No: " + rollNo + " | Grade: " + grade;
    }
}


public class StudentManagementSystem {

    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Student Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Edit Student");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent(sc);
                    break;

                case 2:
                    removeStudent(sc);
                    break;

                case 3:
                    searchStudent(sc);
                    break;

                case 4:
                    displayAll();
                    break;

                case 5:
                    editStudent(sc);
                    break;

                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);

        sc.close();
    }

    
    static void addStudent(Scanner sc) {
        System.out.print("Enter Name: ");
        String name = sc.next();

        System.out.print("Enter Roll No: ");
        int roll = sc.nextInt();

        System.out.print("Enter Grade: ");
        String grade = sc.next();

        students.add(new Student(name, roll, grade));
        System.out.println("Student added!");
    }

    
    static void removeStudent(Scanner sc) {
        System.out.print("Enter Roll No: ");
        int roll = sc.nextInt();

        students.removeIf(s -> s.rollNo == roll);
        System.out.println("Student removed (if existed).");
    }

    
    static void searchStudent(Scanner sc) {
        System.out.print("Enter Roll No: ");
        int roll = sc.nextInt();

        for (Student s : students) {
            if (s.rollNo == roll) {
                System.out.println("Found: " + s);
                return;
            }
        }
        System.out.println("Student not found!");
    }

   
    static void displayAll() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        for (Student s : students) {
            System.out.println(s);
        }
    }

    
    static void editStudent(Scanner sc) {
        System.out.print("Enter Roll No: ");
        int roll = sc.nextInt();

        for (Student s : students) {
            if (s.rollNo == roll) {
                System.out.print("Enter new name: ");
                s.name = sc.next();

                System.out.print("Enter new grade: ");
                s.grade = sc.next();

                System.out.println("Student updated!");
                return;
            }
        }
        System.out.println("Student not found!");
    }
}