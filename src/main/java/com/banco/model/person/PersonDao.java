package com.banco.model.person;

import com.banco.model.dao.GenericDao;
import com.banco.model.dao.GenericDaoImpl;

import javax.transaction.Transactional;
import java.util.List;

public class PersonDao {

    private GenericDao<Person> genericDao;

    public PersonDao() {
        this.genericDao = new GenericDaoImpl<>();
    }

    public void savePerson(Person person) {
        genericDao.save(person);
    }

    @Transactional
    public void alterPerson(Person person) {
        genericDao.alter(person);
    }

    @Transactional
    public void deletePerson(Person person) {
        genericDao.delete(person);
    }

    public List<Person> listPersons() {
        return genericDao.findAll(Person.class);
    }
}
