package models;

import java.util.ArrayList;
import java.util.List;

public class Lessons {
    private Long Id;
    private String lessonsName;
    private String taskdescription;

    List<Group>groups = new ArrayList<>();

    public Lessons() {
    }

    public Lessons(Long id, String lessonsName, String taskdescription, List<Group> groups) {
        Id = id;
        this.lessonsName = lessonsName;
        this.taskdescription = taskdescription;
        this.groups = groups;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getLessonsName() {
        return lessonsName;
    }

    public void setLessonsName(String lessonsName) {
        this.lessonsName = lessonsName;
    }

    public String getTaskdescription() {
        return taskdescription;
    }

    public void setTaskdescription(String taskdescription) {
        this.taskdescription = taskdescription;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    @Override
    public String toString() {
        return "Lessons{" +
                "Id=" + Id +
                ", lessonsName='" + lessonsName + '\'' +
                ", taskdescription='" + taskdescription + '\'' +
                ", groups=" + groups +
                '}';
    }
}
