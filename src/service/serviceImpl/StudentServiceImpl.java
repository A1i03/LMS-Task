package service.serviceImpl;

import database.DataBase;
import exceptions.MyException;
import models.Group;
import models.Lessons;
import models.Student;
import service.StudentService;

import java.beans.Customizer;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;


public class StudentServiceImpl implements StudentService {

    @Override
    public String addNewStudentToGroup(String groupName, Student student) {
        boolean isExit = false;
        try {
            if (!DataBase.groups.isEmpty()) {
                for (Group group : DataBase.groups) {
                    if (group.getNameGroup().equalsIgnoreCase(groupName)) {
                        for (Student student1 : DataBase.students) {
                            if (student1.getEmail().equalsIgnoreCase(student.getEmail())) {
                                isExit = true;
                                break;
                            }
                        }
                        if (!isExit) {
                            System.out.println("group.getLessons() = " + group.getLessons());
                            for (Lessons lesson : DataBase.lessons) {
                                student.setLessons((lesson));
                            }
                            group.setStudents((student));
                            DataBase.students.add(student);
                            return "Student " + student.getFirstName() + " " + student.getLastname() + " has been successfully added to the " + groupName;
                        }
                        return ("The student is already in this group!");
                    }else{
                        throw new MyException("Мындай студент жок!\n кайра туура жазыныз");
                    }
                }
            }else{
                throw new MyException("Мындай группа дата базада жок\n кайра жазыныз");
            }

        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Student updateStudent(String oldStudentEmail, String oldStudentPassword, String newStudentEmail, String newStudentPassword) {
        try {
            Student foundStudent = null;
            for (Student student : DataBase.students) {
                if (student.getEmail().equals(oldStudentEmail) && student.getPassword().equals(oldStudentPassword)) {
                    student.setEmail(newStudentEmail);
                    student.setPassword(newStudentPassword);
                    foundStudent = student;
                    break;
                }
            }
            if (foundStudent == null) {
                throw new MyException("Студент с указанной почтой и паролем не найден.");
            }
            return foundStudent;
        } catch (MyException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Student findStudentByFirstName(String firstName) {
        try {

            for (Student student : DataBase.students) {
                if (student.getFirstName().equals(firstName)) {
                    return student;
                }else {
                    throw new MyException("Студент мындай аты менен табылган жок: ");
                }
            }

        }
        catch (MyException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Student> getAllStudentsByGroupName(String groupName) {
        try {


            for (Group group : DataBase.groups) {
                if (group.getNameGroup().equals(groupName)) {
                    return group.getStudents();
                }
                else {
                    throw new MyException("Группа  мындай аты менен табылган жок: ");
                }
            }
        }  catch (MyException e){
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public List<Lessons> getAllStudentLesson(String studentEmail) {
        try {
            for (Student student : DataBase.students) {
                if (student.getEmail().equals(studentEmail)) {
                    return student.getLessons();
                }else {
                    throw new MyException("Мындай урок жок");
                }
            }
        }
        catch (MyException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String deleteStudentByEmail(String studentEmail) {
        try {
            List<Student> students = DataBase.students;
            for (Student student : students) {
                if (student.getEmail().equals(studentEmail)) {
                    students.remove(student);
                    return " Ийгиликтуу очурулду";
                }else {
                    throw new MyException("Мындай студент жок");
                }
            }

            DataBase.getStudents().addAll(students);
        }catch (MyException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
