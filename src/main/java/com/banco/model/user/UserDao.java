package com.banco.model.user;

import com.banco.model.dao.GenericDao;
import com.banco.model.dao.GenericDaoImpl;

import java.util.List;

public class UserDao {

    private GenericDao<User> genericDao;

    public UserDao() {
        genericDao = new GenericDaoImpl<>();
    }

    public void saveUser(User user) {
        genericDao.save(user);
    }

    public void alterUser(User user) {
        genericDao.alter(user);
    }

    public void deleteUser(User user) {
        genericDao.delete(user);
    }

    public List<User> listUsers() {
        return genericDao.findAll(User.class);
    }

}
