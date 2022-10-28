package com.orient.dao.inter;

import com.orient.entity.Skill;

import java.util.List;

public interface SkillDaoInter {

    public List<Skill> getAllSkillByUserId(int id);

    List<Skill> getAll();

    public Skill getById(int id);

    boolean updateSkill(Skill u);

    boolean removeSkill(int id);

    public List<Skill> getByName(String name);

    public boolean insertSkill(Skill skl);

}
