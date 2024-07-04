package com.SpringSecurity.AuthAgainstDBPractice1.sddl.utils;

import com.SpringSecurity.AuthAgainstDBPractice1.account.entitiy.Users;
import com.SpringSecurity.AuthAgainstDBPractice1.account.service.UsersService;
import com.SpringSecurity.AuthAgainstDBPractice1.account.service.UsersToUsersDetails;
import org.springframework.beans.factory.annotation.Autowired;

public class GetUser {
    //@Autowired
    UsersService usersService = new UsersService();
    public Users getUser(int phone){
        Users users = usersService.getUser(String.valueOf(phone));
        /*
        users.setPhone(usersDetails.getPhone());
        users.setEmail(usersDetails.getUsername());
        users.setPassword(usersDetails.getPassword());
        //users.setRoles(usersDetails.getRoles());
        */
        return users;
    }
}
