package models;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private Long Id;
    private String nameGroup;
    private String discription;
    private List<Lessons> lessons = new ArrayList<>();
    private List<Student> students = new ArrayList<>();

    public Group() {
    }

    public Group(Long id, String nameGroup, String discription, List<Lessons> lessons, List<Student> students) {
        Id = id;
        this.nameGroup = nameGroup;
        this.discription = discription;
        this.lessons = lessons;
        this.students = students;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNameGroup() {
        return nameGroup;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public List<Lessons> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lessons> lessons) {
        this.lessons = lessons;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(Student student) {
        students.add(student);
    }
    public void setLesson(Lessons lesson){
        lessons.add(lesson);
}

    @Override
    public String toString() {
        return "\nGroup{" +
                "Id=" + Id +
                ", nameGroup='" + nameGroup + '\'' +
                ", discription='" + discription + '\'' +
                ", \nlessons=" + lessons +
                ", \nstudents=" + students +
                '}';
    }
    public void setStudent(Student student){
        students.add(student);
    }
}
