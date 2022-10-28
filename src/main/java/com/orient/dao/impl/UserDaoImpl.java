package com.orient.dao.impl;
import com.orient.dao.inter.UserDaoInter;
import com.orient.dao.inter.AbstractDAO;
import com.orient.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
@Service
public class UserDaoImpl extends AbstractDAO implements UserDaoInter {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<User> getAll(String name, String surname, Integer nationalityId) {

        String jpql = "select u from User u where 1=1";

//            String sql = "SELECT\n"
//                    + "\tu.*,\n"
//                    + "\tn.nationality,\n"
//                    + "\tc.NAME AS birthplace \n"
//                    + "FROM\n"
//                    + "\tUSER u\n"
//                    + "\tLEFT JOIN country n ON u.nationality_id = n.id\n"
//                    + "\tLEFT JOIN country c ON u.birthplace_id = c.id \n"
//                    + "WHERE\n"
//                    + "\t1 =1";
        if (name != null && !name.trim().isEmpty()) {
            jpql += " and u.name=:name ";
        }

        if (surname != null && !surname.trim().isEmpty()) {
            jpql += " and u.surname=:surname ";
        }

        if (nationalityId != null) {
            jpql += " and u.nationality.id=:nid ";
        }

        Query query = em.createQuery(jpql, User.class);

        if (name != null && !name.trim().isEmpty()) {
            query.setParameter("name", name);
        }
        if (surname != null && !surname.trim().isEmpty()) {
            query.setParameter("surname", surname);
        }
        if (nationalityId != null) {
            query.setParameter("nid", nationalityId);
        }

        return query.getResultList();
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {

        Query q = em.createQuery("select u from User u where u.email=:e and u.password=:p", User.class);
        q.setParameter("e", email);
        q.setParameter("p", password);

        List<User> list = q.getResultList();

        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public User findByEmail(String email) {

        Query q = em.createQuery("select u from User u where u.email=:e", User.class);
        q.setParameter("e", email);

        List<User> list = q.getResultList();

        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

//    private static BCrypt.Hasher crypt = BCrypt.withDefaults();

    @Override
    public boolean addUser(User u) {
        u.setPassword(u.getPassword());
        em.persist(u);

        return true;
    }

    public boolean updateUser(User u) {
        em.merge(u);

        return true;

    }

    public boolean removeUser(int id) {

        User u = em.find(User.class, id);
        em.remove(u);

        return true;
    }

    @Override
    public User getById(int userId) {

        User u = em.find(User.class, userId);
        em.close();
        return u;

    }

}
