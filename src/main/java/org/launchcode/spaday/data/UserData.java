package org.launchcode.spaday.data;

import org.launchcode.spaday.models.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UserData {
    private static Map<Integer, User> userList = new HashMap<>();


    public static void addUser(User user) {
        userList.put(user.getId(), user);
    }

    public static Collection<User> getAll() {

        return userList.values();
    }

    public static User getById(int id){
        return userList.get(id);
    }

}
