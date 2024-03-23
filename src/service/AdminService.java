package service;

import role.Admin;

public interface AdminService {
     String goOut(String email,String password);
    void willChange(String email,String newPassword);
}