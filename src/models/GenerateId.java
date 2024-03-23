package models;

public class GenerateId {
    public static Long groupsId = 0L;
    public static Long studentsId = 0L;

    public static Long studentId = 0L;
    public static Long lessonId = 0L;


    public static Long generateGroupsId() {
        return ++groupsId;
    }

    public static Long generateStudent() {
        return ++studentsId;

    }

    public static Long genStudentId(){
        return ++studentId;
    }

    public static Long genLessonId(){
        return ++lessonId;
    }
}
