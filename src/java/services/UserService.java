/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.RoleDB;
import models.*;
import dataaccess.UserDB;
import java.util.List;

/**
 *
 * @author BTran
 */
public class UserService {
    public List<User> getAll() throws Exception {
        UserDB userDB = new UserDB();
        List<User> users = userDB.getAll();
        return users;
    }
    public User get(String email) throws Exception {
        UserDB userDB = new UserDB();
        User user = userDB.get(email);
        return user;
    }
    
    public void insert(String email, boolean activity, String first_name, String last_name, String password, Role role) throws Exception{
        User user = new User(email, activity, first_name, last_name, password);
        RoleDB roleDB = new RoleDB();
        Role role1 = roleDB.get(role.getRoleID());
        user.setRole(role1);
        UserDB userDB = new UserDB();
        userDB.insert(user);
    }
    
    public void update(String email, boolean activity, String first_name, String last_name, String password, Role role) throws Exception{
        UserDB userDB = new UserDB();
        User user = userDB.get(email);
        user.setFirstName(first_name);
        user.setLastName(last_name);
        user.setRole(role);
        userDB.update(user);
    }
    
    public void delete(String email) throws Exception{
        UserDB userDB = new UserDB();
        User user = userDB.get(email);
        userDB.delete(user);
    }
}






