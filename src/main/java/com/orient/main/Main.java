package com.orient.main;

import com.orient.dao.inter.UserDaoInter;
import com.orient.entity.User;

public class Main {

    public static void main(String[] args) throws Exception {
        UserDaoInter dao = Context.instanceUserDao();

        User u = dao.findByEmail("sarkhanrasullu@gmail.com");
        System.out.println("u="+u);

    }
}
