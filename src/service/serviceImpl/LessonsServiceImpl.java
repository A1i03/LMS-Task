package service.serviceImpl;

import database.DataBase;
import exceptions.MyException;
import models.Group;
import models.Lessons;
import service.LessonsService;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Objects;

public class LessonsServiceImpl implements LessonsService {


    @Override
    public Lessons addNewLessonToGroup(String groupName, Lessons lesson){
               try {
                   if (!DataBase.groups.isEmpty()) {
                       boolean groupFound = false;
                       for (Group group : DataBase.groups) {
                           if (group.getNameGroup().equals(groupName)) {
                               group.setLesson(lesson);
                               DataBase.lessons.add(lesson);
                               System.out.println("Ийгиликтуу кошулду" + lesson);
                               groupFound = true;
                               break;
                           }
                       }
                           if (!groupFound) {
                               throw new MyException("Дата базада мындай группа жок");
                               }
                       }else{
                           throw new MyException("Сенде пока группа жок");
                       }
               }catch (MyException e){
                   System.out.println(e.getMessage());
               }
        return null;
    }

    @Override
    public String getLessonByName(String lessonGetName) {
        try {

            for (Lessons lessons : DataBase.lessons) {
                if (lessons.getLessonsName().equals(lessonGetName)) {
                    System.out.println(lessons);
                } else {
                    throw new MyException( "Мындай сабак табылган жок");
                }
            }
        }catch (MyException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String getAllLessonByGroupName(String groupName) {
        try {
            for (Group group : DataBase.groups) {
                if (group.getNameGroup().equals(groupName)) {
                    return group.getLessons().toString();
                }else {
                    throw new MyException("Мындай урок жок!!!");
                }
            }

        }catch (MyException e){
            System.out.println(e.getMessage());
        }
        return "Мындай группа табылган жок";
    }

    @Override
    public String deleteLessonByName(String lessonName) {
        List<Lessons> lessons = DataBase.lessons;
        try {
            for (Lessons lessons1 : lessons) {
                if (lessons1.getLessonsName().equals(lessonName)) {
                    lessons.remove(lessons1);
                    return lessons1 + "Lesson successfully deleted!";
                } else {
                    throw new MyException("Мындай урок жок");
                }
            }
            DataBase.getLessons().addAll(lessons);
        }catch (MyException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
