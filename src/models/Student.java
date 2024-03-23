package models;

import enums.Gender;
import service.LessonsService;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private Long id;
    private String nameGroup;
    private String firstName;
    private String lastname;
    private String email;
    private String password;
    private String gender;
    private List<Lessons> lessons;
    List<Group> groups = new ArrayList<>();

    public Student() {
    }

    public Student(Long id, String nameGroup, String firstName, String lastname, String email, String password, String gender, List<Lessons> lessons, List<Group> groups) {
        this.id = id;
        this.nameGroup = nameGroup;
        this.firstName = firstName;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.lessons = lessons;
        this.groups = groups;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameGroup() {
        return nameGroup;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Lessons> getLessons() {
        return lessons;
    }

    public void setLessons(Lessons lesson) {
        lessons.add(lesson);
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", nameGroup='" + nameGroup + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                ", lessons=" + lessons +
                ", groups=" + groups +
                '}';
    }
}

