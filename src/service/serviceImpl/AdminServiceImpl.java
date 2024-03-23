package service.serviceImpl;

import database.DataBase;
import role.Admin;
import service.AdminService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AdminServiceImpl implements AdminService {


    @Override
    public String goOut(String email,String password) {
        for (Admin admin : DataBase.admins) {
            if (admin.getEmail().equals(email) && admin.getPassword().equals(password)){
                return "success";
            }
        }
        return "Туура эмес:";
    }


    @Override
    public void willChange(String email,String newPassword) {
        for (Admin admin : DataBase.admins) {
            if (admin.getEmail().equals(email)){
                admin.setPassword(newPassword);
                System.out.println("Ийгиликтуу озгорду: ");
            }else {
                System.out.println("Email туура эмес: ");
                break;
            }
        }

    }


}

