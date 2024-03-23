package service;

import models.Lessons;

import java.util.List;

public interface LessonsService {
    Lessons addNewLessonToGroup(String groupName, Lessons lesson);

    String getLessonByName(String lessonGetName);

    String getAllLessonByGroupName(String groupName);

    String deleteLessonByName(String lessonName);
}
