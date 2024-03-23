package service.serviceImpl;

import database.DataBase;
import models.GenerateId;
import models.Group;
import models.Student;
import service.GroupService;

import java.nio.file.attribute.GroupPrincipal;
import java.util.List;
import java.util.Scanner;

public class GroupServiceImpl implements GroupService {

    @Override
    public String addNewGroup(String nameGroup, String description) {
        for (Group group1 : DataBase.groups) {
            if (group1.getNameGroup().equals(nameGroup)) {
                return "Мындай группа бар: ";
            }
        }
        Group newGroup = new Group();
        newGroup.setId(GenerateId.generateGroupsId());
        newGroup.setNameGroup(nameGroup);
        newGroup.setDiscription(description);
        DataBase.groups.add(newGroup);
        if (!(newGroup == null)) {
            return  newGroup.getNameGroup()+" группа ийгиликтуу кошулду";
        } else {
            return  "Мындай группа жок";
        }

    }
    @Override
    public Group getGroupByName(String groupName) {
        for (Group group : DataBase.groups) {
            if (group.getNameGroup().equals(groupName)) {
                return group;
            }
        }
        return null;
    }

    @Override
    public List<Group> getAllGroups() {
        return DataBase.groups;
    }

    @Override
    public String updateGroupName(String oldGroupName, String newGroupName) {
        for (Group group : DataBase.groups) {
            if (group.getNameGroup().equals(oldGroupName)) {
                group.setNameGroup(newGroupName);
                return "Succsess ";

            }
        }
        return null;
    }

    @Override
    public String deleteGroupByName(String groupName) {
        List<Group>groups = DataBase.groups;
        for (Group group : groups) {
            if (group.getNameGroup().equals(groupName)) {
                groups.remove(group);
                return group + " Группа ийгиликтуу очурулду";
            }
            DataBase.getGroups().addAll(groups);
        }
        return null;
    }


}
