package com.orient.service.impl;

import com.orient.dao.impl.UserSkillDaoImpl;
import com.orient.dao.inter.AbstractDAO;
import com.orient.dao.inter.UserSkillDaoInter;
import com.orient.entity.UserSkill;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserSkillServiceImpl  implements UserSkillDaoInter {

    @Autowired
    UserSkillDaoImpl userSkillDao;


    @Override
    public List<UserSkill> getAllSkillByUserId(int userId) {
        return userSkillDao.getAllSkillByUserId(userId);
    }

}
