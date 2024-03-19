import java.util.*;

public class StudentSystem {

    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        do {

            int choice = studInformation(scanner);

            switch (choice) {

                case 1:
                    studEnrollment(scanner);
                    break;

                case 2:
                    viewStudInfos(scanner);
                    break;

                case 3:
                    updateInfo(scanner);
                    break;

                case 4:
                    recordGrade(scanner);
                    break;

                case 5:
                    viewGrade(scanner);
                    break;

                case 6:
                    exitMsg();
                    break;

                default:
                    System.out.println("Invalid Choice!");
                    
            }

        } while (true);

    }

    public static int studInformation(Scanner scan) {

        System.out.println("ACTIONS: ");
        System.out.println("1. Enroll a new student");
        System.out.println("2. View student information");
        System.out.println("3. Update student information");
        System.out.println("4. Record grades");
        System.out.println("5. View grades");
        System.out.println("6. Exit");

        System.out.print("\nEnter a choice: ");

        return scan.nextInt();

    }

    public static void studEnrollment(Scanner scan) {

        System.out.print("Enter Student Name: ");
        String studName = scan.next();

        System.out.print("Enter Student ID: ");
        int studID = scan.nextInt();

        System.out.print("Enter Student Course: ");
        String studCourse = scan.next();

        System.out.print("Enter Admission Date (YYYY-MM-DD): ");
        String date = scan.next();

        Student newStudent = new Student();
        newStudent.setName(studName);
        newStudent.setID(studID);
        newStudent.setCourse(studCourse);
        newStudent.setDate(date);

        students.add(newStudent);

        System.out.println("Student " + newStudent.getName() + " Enrolled Successfully!");
    }

    public static void viewStudInfos(Scanner scan) {

        System.out.print("Enter Student ID: ");
        int studIDs = scan.nextInt();
        boolean found = false;

        for (Student s : students) {
            if (studIDs == s.getID()) {
                System.out.println("| NAME | COURSE | ADMISSION DATE |");
                System.out.println(String.format("| %-20s | %-20s | %-20s |", s.getName(), s.getCourse(), s.getDate()));
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student with ID " + studIDs + " not found.");
        }
    }

    public static void updateInfo(Scanner scan) {

        System.out.print("Enter Student ID: ");
        int studID = scan.nextInt();
        boolean found = false;

        for (Student s : students) {
            if (studID == s.getID()) {
                found = true;

                System.out.println("Enter new name (Press enter to keep current): ");
                String newName = scan.next();

                System.out.println("Enter new course (Press enter to keep current): ");
                String newCourse = scan.next();

                if (!newName.isEmpty()) {
                    s.setName(newName);
                    s.setCourse(newCourse);
                }

                System.out.println("Student information updated successfully for " +
                        s.getName() + " (Student ID: " + s.getID() + ")");
                break;
            }
        }

        if (!found) {
            System.out.println("Student with ID " + studID + " not found.");
        }
    }

    public static void recordGrade(Scanner scan) {

        System.out.print("Enter Student ID: ");
        int studID = scan.nextInt();
        boolean found = false;

        for (Student s : students) {
            if (studID == s.getID()) {
                found = true;

                System.out.println("Enter course name: ");
                String course = scan.next();

                s.setNewCourse(course);

                System.out.println("Enter grade:");
                String grade = scan.next();

                s.setGrade(grade);

                System.out.println("Enter Grade record successfully for "
                        + s.getName() + " student ID: " + s.getID() + " )");

                break;
            }
        }

        if (!found) {
            System.out.println("Student with ID " + studID + " not found.");
        }

    }

    public static void viewGrade(Scanner scan) {

        System.out.print("Enter Student ID: ");
        int studID = scan.nextInt();
        boolean found = false;

        for (Student s : students) {
            if (studID == s.getID()) {
                found = true;

                System.out.println("Enter Grade record successfully for "
                        + s.getName() + " student ID: " + s.getID() + " )");

                System.out.println("| Course | Grade |");
                System.out.println(String.format("| %-20s | %-2s |", s.getNewCourse(), s.getGrade()));

                break;
            }
        }

        if (!found) {
            System.out.println("Student with ID " + studID + " not found.");
        }

    }

    public static void exitMsg() {
        System.out.println("THANK YOU AND HAVE A GOOD DAY!");
        System.exit(0);
    }

}

class Student {

    private String studName, studCourse, date, newStudCourse, grade;
    private int studID;

    void setName(String studName) {

        this.studName = studName;

    }

    String getName() {

        return this.studName;

    }

    void setCourse(String studCourse) {
        
        this.studCourse = studCourse;

    }

    String getCourse() {

        return this.studCourse;

    }

    void setNewCourse(String newStudCourse) {

        this.newStudCourse = newStudCourse;

    }

    String getNewCourse() {

        return this.newStudCourse;

    }

    void setID(int studID) {

        this.studID = studID;

    }

    int getID() {

        return this.studID;

    }

    void setDate(String date) {

        this.date = date;

    }

    String getDate() {

        return this.date;

    }

    void setGrade(String grade) {

        this.grade = grade;

    }

    String getGrade() {

        return this.grade;
        
    }

}