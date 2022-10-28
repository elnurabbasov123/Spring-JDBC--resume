package com.orient.dao.inter;

import com.orient.entity.EmploymentHistory;

import java.util.List;

public interface EmploymentHistoryDaoInter {

    public List<EmploymentHistory> getAllEmploymentHistoryByUserId(int userId);

}
