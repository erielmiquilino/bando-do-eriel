package com.banco.model.account;

import com.banco.model.dao.GenericDao;
import com.banco.model.dao.GenericDaoImpl;

import javax.transaction.Transactional;
import java.util.List;

public class AccountDao {
    
    private GenericDao genericDao;

    public AccountDao() {
        this.genericDao = new GenericDaoImpl();
    }

    public void saveAccount(Account account) {
        this.genericDao.save(account);
    }

    @Transactional
    public void alterAccount(Account account) {
        genericDao.alter(account);
    }

    @Transactional
    public void deleteAccount(Account account) {
        genericDao.delete(account);
    }

}
