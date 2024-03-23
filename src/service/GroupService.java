package service;


import models.GenerateId;
import models.Group;
import models.Student;

import java.util.ArrayList;
import java.util.List;

public interface GroupService {
    String addNewGroup(String nameGroup, String description);
    Group getGroupByName(String groupName);
    String updateGroupName(String oldGroupName, String newGroupName);
    List<Group> getAllGroups();
    String deleteGroupByName(String groupName);

}