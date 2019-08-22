package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class UserList {

    private List<User> usersList;

    public UserList(){
        usersList = new ArrayList<User>();
    }
    void addUser(User newUser) {
        usersList.add(newUser);
    }


    public User getUser(String libraryId, String password) {
        for(User user: usersList){
            if(libraryId.equals(user.getLibraryId())  && user.checkPassword(password)){
                return user;
            }
        }
        return null;
    }






}
