package com.banco.model.user;

import com.banco.util.HibenateFactory;
import org.hibernate.Session;

import javax.persistence.NoResultException;
import java.util.Optional;

public class UserPersonalizedDao {

    private Session session;

    private Session getSession(){
        if(this.session == null || !this.session.isOpen()){
            this.session = HibenateFactory.getSession();
        }
        return this.session;
    }


    public Optional<User> userFromUserAndPassword(String mail, String password) {
        try {
            return Optional.ofNullable(getSession().createQuery("SELECT u FROM User u WHERE u.mail = :mail AND u.password = :password", User.class)
                    .setParameter("mail", mail)
                    .setParameter("password", password)
                    .getSingleResult());
        }catch (Exception e) {
            return Optional.empty();
        }
    }
}
