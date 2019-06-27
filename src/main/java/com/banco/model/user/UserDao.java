package com.banco.model.user;

import com.banco.model.dao.GenericDao;
import com.banco.model.dao.GenericDaoImpl;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public class UserDao {

    private GenericDao<User> genericDao;
    private UserPersonalizedDao userPersonalizedDao;

    public UserDao() {
        genericDao = new GenericDaoImpl<>();
        userPersonalizedDao = new UserPersonalizedDao();
    }

    public void saveUser(User user) {
        genericDao.save(user);
    }

    @Transactional
    public void alterUser(User user) {
        genericDao.alter(user);
    }

    @Transactional
    public void deleteUser(User user) {
        genericDao.delete(user);
    }

    public List<User> listUsers() {
        return genericDao.findAll(User.class);
    }

    public boolean isValidUser (String mail, String password) {
        Optional user = userPersonalizedDao.userFromUserAndPassword(mail, password);
        return user.isPresent();
    }

}
