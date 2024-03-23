package database;

import models.Group;
import models.Lessons;
import models.Student;
import role.Admin;

import java.security.Key;
import java.util.ArrayList;
import java.util.List;

public class DataBase {
    public static List<Group> groups = new ArrayList<>();
    public static List<Student> students = new ArrayList<>();
    public static List<Lessons> lessons = new ArrayList<>();
    public static List<Admin> admins = new ArrayList<>();


    public static List<Student> getStudents() {
        return students;
    }

    public static void setStudents(List<Student> students) {
        DataBase.students = students;
    }
    public static List<Lessons> getLessons() {
        return lessons;
}

    public static void setLessons(List<Lessons> lessons) {
        DataBase.lessons = lessons;
    }
    public static List<Group> getGroups() {
        return groups;
    }

    public static void setGroups(List<Group> groups) {
        DataBase.groups = groups;
    }
}