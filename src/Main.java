import database.DataBase;
import enums.Gender;
import exceptions.MyException;
import models.GenerateId;
import models.Group;
import models.Lessons;
import models.Student;
import role.Admin;
import service.StudentService;
import service.serviceImpl.AdminServiceImpl;
import service.serviceImpl.GroupServiceImpl;
import service.serviceImpl.LessonsServiceImpl;
import service.serviceImpl.StudentServiceImpl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static database.DataBase.lessons;

public class Main {
    public static void main(String[] args) throws MyException {
        StudentServiceImpl studentService = new StudentServiceImpl();
        LessonsServiceImpl lessonsService = new LessonsServiceImpl();
        GroupServiceImpl groupService = new GroupServiceImpl();
        AdminServiceImpl adminService = new AdminServiceImpl();

        Group group = new Group();


        LocalDate data = LocalDate.now();
        LocalTime time = LocalTime.now();

        String wish;
        if (time.getHour() > 6 && time.getHour() <= 12) {
            wish = "Good morning";
        } else if (time.getHour() > 12 && time.getHour() <= 18) {
            wish = "Good afternoon";
        } else if (time.getHour() > 18 && time.getHour() <= 21) {
            wish = "Good evening";
        } else {
            wish = "Good night";
        }

        System.out.println(data + "\n" + wish + " Time is => " + time.getHour() + " : " + time.getMinute());
        Admin admin = new Admin("ali@gmail.com", "123456789");
        DataBase.admins.add(admin);

        boolean isTrue = false;
        while (isTrue) {
            System.out.println("Катталган болсонуз 1-басыныз, парольду унутуп калсаныз озгортуу учсун 2 басыныз: ");
            try {
                switch (new Scanner(System.in).nextInt()) {

                    case 1: {

                        System.out.println("Кируу учун электрондук почтанызды жана паролунузду жазыныз!!!");
                        System.out.println("Электрондук постанызды жазыныз: ");
                        String email = new Scanner(System.in).nextLine();
                        System.out.println("Пароль жазыныз: ");
                        if (adminService.goOut(email, new Scanner(System.in).nextLine()).equalsIgnoreCase("success")) {
                            isTrue = false;
                            break;
                        } else {
                            System.out.println("Туура эмес парлоль же туура эмес почта: ");
                            break;
                        }
                    }
                    case 2: {
                        System.out.println("Email жазыныз: ");
                        String email = new Scanner(System.in).nextLine();
                        System.out.println("Жаны пароль жазыныз: ");
                        adminService.willChange(email, new Scanner(System.in).nextLine());
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("Туура жазыныз: ");
            }
        }

        while (true) {
            System.out.println("Команданын танданыз: ");
            System.out.println("""
                    ---------------------------------------------------------------------------------------
                    -----------------------------------Choose operation------------------------------------
                    ---------------------------------------------------------------------------------------
                    1 -> Add new group                              9  -> Get all student's lesson
                    2 -> Get group by name                          10 -> Delete student
                    3 -> Update group name                          11 -> Add new lesson to group
                    4 -> Get all groups                             12 -> Get lesson by name
                    5 -> Add new student to group                   13 -> Get all lesson by group name
                    6 -> Update student                             14 -> Delete lesson
                    7 -> Find student by first name                 15 -> Delete group
                    8 -> Get all students by group name             16 -> Exit
                                                                                                     """);
            Scanner scanner = new Scanner(System.in);
            try {
                switch (new Scanner(System.in).nextInt()) {
                    case 1: {
                        System.out.println("Группанын атын жаз: ");
                        String groupName = new Scanner(System.in).nextLine();
                        System.out.println("Группанын описаниясын жаз: ");
                        String groupDescription = new Scanner(System.in).nextLine();
                        System.out.println(groupService.addNewGroup(groupName, groupDescription));
                        break;

                    }
                    case 2: {
                        System.out.println("Групанын атын жаз: ");
                        String newGroup1 = scanner.nextLine();
                        System.out.println(groupService.getGroupByName(newGroup1));
                        break;
                    }
                    case 3: {
                        System.out.println(groupService.getAllGroups());
                        break;
                    }
                    case 4: {
                        System.out.println("Групанын атын жаз: ");
                        String old = scanner.nextLine();
                        System.out.println("Жаны ат жазыныз: ");
                        String newName = scanner.nextLine();
                        System.out.println(groupService.updateGroupName(old, newName));
                        break;
                    }
                    case 5: {

                        System.out.println("Write group name: ");
                        String groupName = scanner.nextLine();

                        System.out.println("Write students first name: ");
                        String fistName = scanner.nextLine();

                        System.out.println("Write students last name: ");
                        String lastName = scanner.nextLine();

                        System.out.println("Write student email: ");
                        String email = scanner.nextLine();

                        if (!email.contains("@") && !email.contains(".")) {
                            System.out.println("Email should contain '@' and dot. \n Try again");
                        }

                        System.out.println("Create a new password with the lenth at least of 8 symbols");
                        System.out.println("Write students password: ");
                        String studentPassword = scanner.nextLine();

                        if (studentPassword.length() < 8) {
                            System.out.println("Password should consist of at least 8 symbols");
                        }

                        System.out.println("Студентин жынысын жаз MALE/FEMALE: ");
                        String studentGender = scanner.nextLine();

                        if (studentGender.equalsIgnoreCase(Gender.MALE.name())) {
                            studentGender = Gender.MALE.name();
                        } else if (studentGender.equalsIgnoreCase(Gender.FEMALE.name())) {
                            studentGender = Gender.FEMALE.name();
                        } else {
                            System.out.println("Worn gender");
                        }
                        Student student1 = new Student(GenerateId.generateGroupsId(), groupName, fistName, lastName, email, studentPassword, studentGender, new ArrayList<>(), new ArrayList<>());
                        System.out.println(studentService.addNewStudentToGroup(groupName, student1));
                        break;
                    }
                    case 6: {
                        Student student = new Student();
                        System.out.println("Почтанызды жазыныз: ");
                        String email = scanner.nextLine();
                        System.out.println("Паролюнузду жазыныз: ");
                        String password = new Scanner(System.in).nextLine();
                        System.out.println("Жаны почтанызды жазыныз: ");
                        String newEmail = scanner.nextLine();
                        System.out.println("Жаны пароль жазыныз: ");
                        String newPassword = new Scanner(System.in).nextLine();
                        System.out.println(studentService.updateStudent(email, password, newEmail, newPassword));
                        break;
                    }
                    case 7: {
                        System.out.println("Студенттин атын жазыныз:");
                        String newStudent = new Scanner(System.in).nextLine();
                        Student studentList = studentService.findStudentByFirstName(newStudent);
                        if (!(studentList == null)) {
                            System.out.println(studentList);
                        } else {
                            System.out.println("Туура  жаз: ");
                            System.out.println(studentList);
                        }
                        break;
                    }
                    case 8: {
                        System.out.println("Групанын атын жазыныз: ");
                        String groupName = scanner.nextLine();
                        List<Student> studentList = studentService.getAllStudentsByGroupName(groupName);
                        if (studentList == null) {
                            System.out.println("Туура эмес жаздыныз: ");
                        } else {
                            System.out.println(studentList);
                        }
                        break;
                    }
                    case 9: {
                        System.out.println("Студентин почтасын жазыныз: ");
                        String emailStudent = new Scanner(System.in).nextLine();
                        if ((!(emailStudent == null))) {
                            System.out.println(studentService.getAllStudentLesson(emailStudent));
                        } else {
                            System.out.println("туура эмес жаздыныз: ");
                        }
                        break;
                    }
                    case 10: {
                        try {
                            System.out.print("Студенттин email жазыныз: ");
                            String email = new Scanner(System.in).nextLine();
                            System.out.println(studentService.deleteStudentByEmail(email));
                        } catch (StackOverflowError e) {
                            System.out.println("Произошла ошибка: " + e.getMessage());
                        }
                    }
                    case 11: {
                        Lessons lessons = new Lessons();
                        lessons.setId(GenerateId.genLessonId());
                        System.out.println("Группанын атын жаз: ");

                        String ANameOfGroup = new Scanner(System.in).nextLine();

                        System.out.println("Сабактын атын жаз: ");
                        lessons.setLessonsName(new Scanner(System.in).nextLine());

                        System.out.println("тапшырманын сүрөттөмөсүн жаз: ");
                        lessons.setTaskdescription(new Scanner(System.in).nextLine());

                        System.out.println(lessonsService.addNewLessonToGroup(ANameOfGroup, lessons));
                        break;

                    }
                    case 12: {
                        System.out.println("Группанын атын жазыныз: ");
                        String newGroup = new Scanner(System.in).nextLine();
                        System.out.println(lessonsService.getAllLessonByGroupName(newGroup));
                        break;
                    }
                    case 13: {
                        System.out.println("Сабактын атын жазыныз: ");
                        String newLesson = scanner.nextLine();
                        System.out.println(lessonsService.getLessonByName(newLesson));
                        break;
                    }
                    case 14: {
                        System.out.println("Очуро турган сабагынызды жазыныз: ");
                        String deleteStudent = scanner.nextLine();
                        System.out.println(lessonsService.deleteLessonByName(deleteStudent));
                        break;
                    }
                    case 15: {
                        System.out.println("Очуро турган групанызды жазыныз:  ");
                        String deleteGroupName = new Scanner(System.in).nextLine();
                        System.out.println(groupService.deleteGroupByName(deleteGroupName));
                        break;
                    }
                    case 16: {
                        System.out.println("Кош бол жаным");
                        return;
                    }


                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

}



