package com.orient.main;


import com.orient.dao.impl.*;
import com.orient.dao.inter.*;
import com.orient.service.impl.*;
import com.orient.service.inter.*;

public class Context {
    public static UserDaoInter instanceUserDao(){
        return new UserDaoImpl();
    }

    public static UserSkillDaoInter instanceUserSkillDao(){
        return new UserSkillDaoImpl();
    }

    public static EmploymentHistoryDaoInter instanceEmploymentHistoryDao(){
        return new EmploymentHistoryDaoImpl();
    }

    public static CountryDaoInter instanceCountryDao(){
        return new CountryDaoImpl();
    }
    
    public static SkillDaoInter instanceSkillDao(){
        return new SkillDaoImpl();
    }
}
