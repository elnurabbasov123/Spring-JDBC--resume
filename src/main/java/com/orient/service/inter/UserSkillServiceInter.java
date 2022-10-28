package com.orient.service.inter;

import com.orient.entity.UserSkill;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserSkillServiceInter {

    public List<UserSkill> getAllSkillByUserId(int userId);
}
