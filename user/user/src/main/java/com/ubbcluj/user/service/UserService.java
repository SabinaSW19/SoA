package com.ubbcluj.user.service;

import com.ubbcluj.user.domain.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    private List<User> users=new ArrayList<>(Arrays.asList(new User("s.dumistracel@yahoo.com","12345"),
            new User("sabi.dumistracel@gmail.com","secure")));

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
