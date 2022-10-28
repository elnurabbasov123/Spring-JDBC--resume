package com.orient.service.impl;
import com.orient.dao.impl.UserDaoImpl;
import com.orient.dao.inter.UserDaoInter;
import com.orient.dao.inter.UserRepository;
import com.orient.entity.User;
import com.orient.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class UserServiceImpl implements UserServiceInter {

    @Autowired
    UserDaoImpl useDao;


    @Override
    public List<User> getAll(String name, String surname, Integer nationalityId) {
       return  useDao.getAll(name,surname,nationalityId);

    }

    @Override
    public User findByEmailAndPassword(String email, String password) {

       return useDao.findByEmailAndPassword(email,password);
    }

    @Override
    public User findByEmail(String email) {

       return useDao.findByEmail(email);
    }

//    private static BCrypt.Hasher crypt = BCrypt.withDefaults();

    @Override
    public boolean addUser(User u) {
        return useDao.addUser(u);
    }

    public boolean updateUser(User u) {
     return useDao.updateUser(u);

    }

    public boolean removeUser(int id) {

      return useDao.removeUser(id);
    }

    @Override
    public User getById(int userId) {

        return useDao.getById(userId);
    }

}
