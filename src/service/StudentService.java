package service;

import models.Group;
import models.Lessons;
import models.Student;

import java.util.List;

public interface StudentService {
        String addNewStudentToGroup(String groupName, Student student);
        Student updateStudent(String oldStudentEmail, String oldStudentPassword, String newStudent, String newStudentPassword);
        Student findStudentByFirstName(String firstName);
        List<Student> getAllStudentsByGroupName(String groupName);
        List<Lessons> getAllStudentLesson(String studentEmail);
        String deleteStudentByEmail(String studentEmail);
    }


